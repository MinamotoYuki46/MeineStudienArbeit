<?php

namespace App\Controllers;
use App\Models\Book;

class Dashboard extends BaseController {
    protected $bookModel;
    
    public function __construct() {
        $this -> bookModel = new Book();
    }
    
    private function checkLogin(){
        if (!session() -> get('isLoggedIn')) {
            return redirect() -> to(base_url('auth/login')) -> with('error', 'Silakan login terlebih dahulu!');
        }
    }
    
    public function index() {
        $this -> checkLogin();
        
        $search = $this -> request -> getGet('search');
        
        if ($search) {
            $books = $this -> bookModel -> like('title', $search)
                                        -> orLike('author', $search)
                                        -> orLike('publisher', $search)
                                        -> orLike('publication_year', $search)
                                        -> findAll();
        } else {
            $books = $this -> bookModel -> findAll();
        }
        
        $data = [
            'books' => $books
        ];
        
        return view('dashboard/index', $data);
    }
    
    public function add(){
        $this -> checkLogin();
        return view('dashboard/add');
    }
    
    public function save(){
        $this -> checkLogin();
        
        $rules = $this -> bookModel -> validationRules;
        $errors = $this -> bookModel -> validationMessages;
        
        if (!$this -> validate($rules, $errors)) {
            return redirect() -> back() -> withInput() -> with('error', $this -> validator -> listErrors());
        }
        
        $data = [
            'title' => $this -> request -> getPost('title'),
            'author' => $this -> request -> getPost('author'),
            'publisher' => $this -> request -> getPost('publisher'),
            'publication_year' => $this -> request -> getPost('publication_year'),
        ];

        if ($this -> bookModel -> isDuplicateBook($data)) {
            return redirect() -> back() -> withInput() -> with('error', 'Buku dengan data yang sama sudah ada!');
        }
        
        try {
            $this -> bookModel -> insert($data);
        } catch (\Exception $e) {
            return redirect() -> back() -> withInput() -> with('error', 'Terjadi kesalahan saat menyimpan data: ' . $e -> getMessage());
        }
        
        return redirect() -> to(base_url('dashboard')) -> with('success', 'Buku berhasil ditambahkan!');
    }
    
    public function edit($id = null){
        $this -> checkLogin();
        
        if ($id === null) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'ID buku tidak valid!');
        }
        
        $book = $this -> bookModel -> find($id);
        
        if (!$book) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'Buku tidak ditemukan!');
        }
        
        $data = [
            'book' => $book
        ];
        
        return view('dashboard/edit', $data);
    }
    
    public function update($id = null){
        $this -> checkLogin();
        
        if ($id === null) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'ID buku tidak valid!');
        }
        
        $rules = $this -> bookModel -> validationRules;
        $errors = $this -> bookModel -> validationMessages;
        
        if (!$this -> validate($rules, $errors)) {
            return redirect() -> back() -> withInput() -> with('error', $this -> validator -> listErrors());
        }
        
        $data = [
            'title' => $this -> request -> getPost('title'),
            'author' => $this -> request -> getPost('author'),
            'publisher' => $this -> request -> getPost('publisher'),
            'publication_year' => $this -> request -> getPost('publication_year'),
        ];

        if ($this -> bookModel -> isDuplicateBook($data)) {
            return redirect() -> back() -> withInput() -> with('error', 'Buku dengan data yang sama sudah ada!');
        }
        
        try {
            $this -> bookModel -> update($id, $data);
        } catch (\Exception $e) {
            return redirect() -> back() -> withInput() -> with('error', 'Terjadi kesalahan saat memperbarui data: ' . $e -> getMessage());
        }
        
        return redirect() -> to(base_url('dashboard')) -> with('success', 'Buku berhasil diperbarui!');
    }
    
    public function delete($id = null) {
        $this -> checkLogin();
        
        if ($id === null) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'ID buku tidak valid!');
        }
        
        $book = $this -> bookModel -> find($id);
        
        if (!$book) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'Buku tidak ditemukan!');
        }
        
        try {
            $this -> bookModel -> delete($id);
        } catch (\Exception $e) {
            return redirect() -> to(base_url('dashboard')) -> with('error', 'Terjadi kesalahan saat menghapus data: ' . $e -> getMessage());
        }
        
        return redirect() -> to(base_url('dashboard')) -> with('success', 'Buku berhasil dihapus!');
    }
}