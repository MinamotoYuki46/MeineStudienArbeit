<?php

namespace App\Models;

class Students {
    public string $name;
    public string $id;
    public string $major;
    public array $hobby;
    public array $skills;
    public array $images;
    public string $birthPlace;
    public string $birthDate;
    public string $university;
    public string $year;
    public string $semester;
    public string $gpa;
    public string $email;
    public string $origin;
    public array $achievements;

    public function __construct(
        string $name = '',
        string $id = '',
        string $major = '',
        array $hobby = [],
        array $skills = [],
        array $images = [],
        string $birthPlace = '',
        string $birthDate = '',
        string $university = '',
        string $year = '',
        string $semester = '',
        string $gpa = '',
        string $email = '',
        string $origin = '',
        array $achievements = []
    ) {
        $this -> name = $name;
        $this -> id = $id;
        $this -> major = $major;
        $this -> hobby = $hobby;
        $this -> skills = $skills;
        $this -> images = $images;
        $this -> birthPlace = $birthPlace;
        $this -> birthDate = $birthDate;
        $this -> university = $university;
        $this -> year = $year;
        $this -> semester = $semester;
        $this -> gpa = $gpa;
        $this -> email = $email;
        $this -> origin = $origin;
        $this -> achievements = $achievements;
    }
}
