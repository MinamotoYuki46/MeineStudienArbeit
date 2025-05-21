<?php

namespace App\Database\Seeds;

use CodeIgniter\Database\Seeder;

class UsersSeeder extends Seeder {
    public function run() {
        $data = [
            [
                'username'   => 'amat',
                'email'      => 'amat@gamail.com',
                'password'   => password_hash('pAssword123', PASSWORD_DEFAULT),
                'created_at' => date('Y-m-d H:i:s'),
                'updated_at' => date('Y-m-d H:i:s'),
            ],
            [
                'username'   => 'budi',
                'email'      => 'budi@yahoo.com',
                'password'   => password_hash('secRet456', PASSWORD_DEFAULT),
                'created_at' => date('Y-m-d H:i:s'),
                'updated_at' => date('Y-m-d H:i:s'),
            ],
            [
                'username'   => 'chandra',
                'email'      => 'chandra@outlook.com',
                'password'   => password_hash('qwertY789', PASSWORD_DEFAULT),
                'created_at' => date('Y-m-d H:i:s'),
                'updated_at' => date('Y-m-d H:i:s'),
            ],
        ];

        $this -> db -> table('users') -> insertBatch($data);
    }
}
