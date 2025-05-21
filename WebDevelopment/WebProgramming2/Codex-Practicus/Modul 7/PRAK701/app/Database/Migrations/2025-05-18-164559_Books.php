<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class Books extends Migration{
     public function up(){
        $this -> forge -> addField([
            'id' => [
                'type'           => 'BIGINT',
                'constraint'     => 11,
                'unsigned'       => true,
                'auto_increment' => true,
            ],
            'title' => [
                'type'       => 'VARCHAR',
                'constraint' => 255,
            ],
            'author' => [
                'type'       => 'VARCHAR',
                'constraint' => 255,
            ],
            'publisher' => [
                'type'       => 'VARCHAR',
                'constraint' => 255,
            ],
            'publication_year' => [
                'type'       => 'YEAR',
                'null'       => true,
            ],
            'created_at' => [
                'type' => 'DATETIME',
                'null' => true,
            ],
            'updated_at' => [
                'type' => 'DATETIME',
                'null' => true,
            ],
        ]);

        $this -> forge -> addKey('id', true); 
        $this -> forge -> createTable('books');
    }

    public function down(){
        $this -> forge -> dropTable('books');
    }
}
