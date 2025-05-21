<?php

namespace App\Controllers;

use App\Models\User;

class Auth extends BaseController {
    public function index()    {
        return redirect() -> to(base_url('auth/login'));
    }
    
    public function login() {
        if (session() -> get('isLoggedIn')) {
            return redirect() -> to(base_url('dashboard'));
        }
        
        return view('auth/login');
    }
    
    public function register() {
        if (session() -> get('isLoggedIn')) {
            return redirect() -> to(base_url('dashboard'));
        }
        
        return view('auth/register');
    }
    
    public function processLogin() {
        $userModel = new User();
        
        $username = $this -> request -> getPost('username');
        $password = $this -> request -> getPost('password');
        
        $isEmail = filter_var($username, FILTER_VALIDATE_EMAIL);
        
        if ($isEmail) {
            $user = $userModel -> where('email', $username) -> first();
        } else {
            $user = $userModel -> where('username', $username) -> first();
        }
        
        if ($user && password_verify($password, $user['password'])) {
            $sessionData = [
                'id' => $user['id'],
                'username' => $user['username'],
                'email' => $user['email'],
                'isLoggedIn' => true
            ];
            
            session() -> set($sessionData);
            
            return redirect() -> to(base_url('dashboard'));
        } else {
            session() -> setFlashdata('error', 'Username/Email atau Password salah.');
            return redirect() -> back() -> withInput();
        }
    }
    
    public function processRegister() {
        $userModel = new User();
        $rules = $userModel -> validationRules;
        $errors = $userModel -> validationMessages;
        
        if (!$this -> validate($rules, $errors)) {
            session() -> setFlashdata('error', $this -> validator -> listErrors());
            return redirect() -> back() -> withInput();
        }
        
        $userData = [
            'username' => $this -> request -> getPost('username'),
            'email' => $this -> request -> getPost('email'),
            'password' => password_hash($this -> request -> getPost('password'), PASSWORD_DEFAULT)
        ];
        
        $userModel = new User();
        $userModel -> insert($userData);
        
        session() -> setFlashdata('success', 'Pendaftaran berhasil! Silakan login.');
        return redirect() -> to(base_url('auth/login'));
    }
    
    public function logout() {
        session() -> destroy();
        
        return redirect() -> to(base_url());
    }
}