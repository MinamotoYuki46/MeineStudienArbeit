<?php

namespace App\Database\Seeds;

use CodeIgniter\Database\Seeder;

class BooksSeeder extends Seeder {
    public function run(){
        $data = [
            [
                'title'          => 'Clean Code',
                'author'         => 'Robert C. Martin',
                'publisher'      => 'Prentice Hall',
                'publication_year' => 2008,
                'created_at'     => date('Y-m-d H:i:s'),
                'updated_at'     => date('Y-m-d H:i:s'),
            ],
            [
                'title'          => 'The Pragmatic Programmer',
                'author'         => 'Andy Hunt, Dave Thomas',
                'publisher'      => 'Addison-Wesley',
                'publication_year' => 1999,
                'created_at'     => date('Y-m-d H:i:s'),
                'updated_at'     => date('Y-m-d H:i:s'),
            ],
            [
                'title'          => 'Introduction to Algorithms',
                'author'         => 'Thomas H. Cormen',
                'publisher'      => 'MIT Press',
                'publication_year' => 2009,
                'created_at'     => date('Y-m-d H:i:s'),
                'updated_at'     => date('Y-m-d H:i:s'),
            ],
        ];

        $this -> db -> table('books') -> insertBatch($data);
    }
}
