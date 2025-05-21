<?php

namespace App\Models;

use CodeIgniter\Model;

class Book extends Model {
    protected $table            = 'books';
    protected $primaryKey       = 'id';
    protected $useAutoIncrement = true;
    protected $returnType       = 'array';
    protected $useSoftDeletes   = false;
    protected $protectFields    = true;
    protected $allowedFields    = ['title', 'author', 'publisher', 'publication_year'];

    protected bool $allowEmptyInserts = false;
    protected bool $updateOnlyChanged = true;

    protected array $casts = [];
    protected array $castHandlers = [];

    protected $useTimestamps = false;
    protected $dateFormat    = 'datetime';
    protected $createdField  = 'created_at';
    protected $updatedField  = 'updated_at';
    protected $deletedField  = 'deleted_at';

    protected $validationRules = [
        'title' => 'required|min_length[3]|max_length[255]',
        'author' => 'required|min_length[3]|max_length[255]',
        'publisher' => 'required|min_length[2]|max_length[255]',
        'publication_year' => 'required|numeric|greater_than[1900]|less_than_equal_to[2025]'
    ];

    protected $validationMessages = [
        'title' => [
            'required' => 'Judul buku harus diisi!',
            'min_length' => 'Judul buku minimal 3 karakter!',
            'max_length' => 'Judul buku maksimal 255 karakter!'
        ],
        'author' => [
            'required' => 'Nama penulis harus diisi!',
            'min_length' => 'Nama penulis minimal 3 karakter!',
            'max_length' => 'Judul buku maksimal 255 karakter!'
        ],
        'publisher' => [
            'required' => 'Nama penerbit harus diisi!',
            'min_length' => 'Nama penerbit minimal 2 karakter!',
            'max_length' => 'Judul buku maksimal 255 karakter!'
        ],
        'publication_year' => [
            'required' => 'Tahun terbit harus diisi!',
            'numeric' => 'Tahun terbit harus berupa angka!',
            'greater_than' => 'Tahun terbit minimal dari tahun 1901!',
            'less_than_equal_to' => 'Tahun terbit maksimal hingga tahun 2025!'
        ]
    ];
    protected $skipValidation       = false;
    protected $cleanValidationRules = true;

    protected $allowCallbacks = true;
    protected $beforeInsert   = [];
    protected $afterInsert    = [];
    protected $beforeUpdate   = [];
    protected $afterUpdate    = [];
    protected $beforeFind     = [];
    protected $afterFind      = [];
    protected $beforeDelete   = [];
    protected $afterDelete    = [];

    public function isDuplicateBook(array $data, ?int $id = null): bool {
        $builder = $this -> builder();

        $builder -> where('title', $data['title']);
        $builder -> where('author', $data['author']);
        $builder -> where('publisher', $data['publisher']);
        $builder -> where('publication_year', $data['publication_year']);

        if ($id !== null) {
            $builder -> where('id !=', $id);
        }

        return $builder->countAllResults() > 0; 
    }
}
