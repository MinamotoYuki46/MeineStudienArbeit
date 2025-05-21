<?php

use CodeIgniter\Router\RouteCollection;

/**
 * @var RouteCollection $routes
 */
$routes -> get('/', 'Home::index');

$routes -> group('auth', function($routes) {
    $routes -> get('/', 'Auth::index');
    $routes -> get('login', 'Auth::login');
    $routes -> get('register', 'Auth::register');
    $routes -> post('processLogin', 'Auth::processLogin');
    $routes -> post('processRegister', 'Auth::processRegister');
    $routes -> get('logout', 'Auth::logout');
});

$routes -> group('dashboard', ['filter' => 'auth'], function($routes) {
    $routes -> get('/', 'Dashboard::index');
    $routes -> get('add', 'Dashboard::add');
    $routes -> post('save', 'Dashboard::save');
    $routes -> get('edit/(:num)', 'Dashboard::edit/$1');
    $routes -> post('update/(:num)', 'Dashboard::update/$1');
    $routes -> delete('delete/(:num)', 'Dashboard::delete/$1');
});