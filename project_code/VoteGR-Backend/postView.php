<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");

            $todate = date("Y-m-d");
			$sql = "SELECT `vote`.`idvote`
			FROM `votegr`.`vote` WHERE `vote`.`starting_date`<= '$todate' AND `vote`.`ending_date`>= '$todate' ;";
			
            $stmt = mysqli_query($db, $sql);
			$data = mysqli_fetch_row($stmt);
            if($data){
                $voteid = $data[0];
            
                $party_opinion = $_POST['party_opinion'];
                $party_id = $_POST['username'];

                $sql = "INSERT INTO `votegr`.`views`
                (
                `party_opinion`,
                `party_id`,
                `vote_id_about`)
                VALUES
                (
                '$party_opinion',
                '$party_id',
                '$voteid');";
                mysqli_query($db, $sql);
            }
		}
		else {
			throw new Exception('Unable to connect');
		}
	}
	catch(Exception $e) {
		echo $e->getMessage();
	}

?>
