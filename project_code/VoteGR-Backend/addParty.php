<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");


            $username = $_POST['username'];
            $password = $_POST['password'];
            $title = $_POST['title'];

            $sql = "INSERT INTO `votegr`.`users`
            (
            `role`,
            `user_detail`)
            VALUES
            (
            'party',
            'komma');";
            
            if (mysqli_query($db, $sql) === TRUE) {
                $last_id = $db->insert_id;
                $sql2 = "INSERT INTO `votegr`.`party`
                (`username`,
                `password`,
                `title`,
                `user_party_id`)
                VALUES
                ('$username',
                '$password',
                '$title',
                '$last_id');";
                mysqli_query($db, $sql2);
              } else {
                echo "Error: " . $sql . "<br>" . $db->error;
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
