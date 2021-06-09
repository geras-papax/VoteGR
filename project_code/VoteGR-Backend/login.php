<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");

            $user_info = $_POST['user_detail'];
            $password = $_POST['password'];

			$sql = "SELECT `users`.`role`
			FROM `votegr`.`users` WHERE `users`.`user_detail`= '$user_info';";

			$stmt = mysqli_query($db, $sql);
			$data = mysqli_fetch_row($stmt);

            if($data){
                $role = $data[0];
                $sql = "SELECT * FROM `votegr`.`$role`
                WHERE `$role`.`password` = '$password';";
                $stmt = mysqli_query($db, $sql);
                $data2 = mysqli_fetch_assoc($stmt);

                if($data2){
                    echo $role;
                }
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
