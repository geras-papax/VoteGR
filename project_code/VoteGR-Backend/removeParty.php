<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");


            $title = $_POST['title'];

			$sql = "SELECT `party`.`username`
			FROM `votegr`.`party` WHERE `party`.`title`= '$title';";

            $stmt = mysqli_query($db, $sql);
			$data = mysqli_fetch_row($stmt);
            if($data){
                $party_username = $data[0];
                $sql = "DELETE FROM `votegr`.`users`
                WHERE `users`.`user_detail` = '$party_username';";
                mysqli_query($db, $sql);
                $sql = "DELETE FROM `votegr`.`party`
                WHERE `party`.`username` = '$party_username';";
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
