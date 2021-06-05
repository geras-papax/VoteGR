<?php
    define('DB_SERVER', 'localhost:3306');
    define('DB_USERNAME', 'root');
    define('DB_PASSWORD', 'pao134ever');
    define('DB_DATABASE', 'votegr');
    $db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

    $todate = date("Y-m-d");
    $sql = "SELECT `vote`.`idvote`,
    `vote`.`subject`,
    `vote`.`starting_date`,
    `vote`.`ending_date`
    FROM `votegr`.`vote` WHERE `vote`.`starting_date`<= '$todate' AND `vote`.`ending_date`>= '$todate' ;";

    $loc = array();

    $stmt = mysqli_query($db, $sql);
    $data = mysqli_fetch_assoc($stmt);
    
    echo json_encode($data,JSON_UNESCAPED_UNICODE);
?>

