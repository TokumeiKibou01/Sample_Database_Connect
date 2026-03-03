<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
$user = 'test_user';
$password = 'testpass';
$database = 'test';
$servername = '';

$pdo = new PDO("mysql:host=$servername;dbname=$database", $user, $password);
$stmt = $pdo->query('SELECT * FROM test_table');
while ($row = $stmt->fetch()) {
    if ($row['id'] == 1) {
        echo "ID: " . $row['id'] . ", Name: " . $row['name'] . "\n";
    }
}
?>
