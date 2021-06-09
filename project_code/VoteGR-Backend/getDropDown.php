<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");

			$todate = date("Y-m-d");
			$sql = "SELECT title FROM party;";
            $sql1 = "SELECT vote.starting_date from votegr.vote;";


			$stmt = mysqli_query($db, $sql);
            $stmt1 = mysqli_query($db, $sql1);
            $data = mysqli_fetch_all($stmt);
            $data1 = mysqli_fetch_all($stmt1);
	
			//echo json_encode($data, JSON_UNESCAPED_UNICODE);
			$result = [
				"parties" => $data,
				"votings" => $data1,
			];


			echo json_encode($result, JSON_UNESCAPED_UNICODE);
		}
		else {
			throw new Exception('Unable to connect');
		}
	}
	catch(Exception $e) {
		echo $e->getMessage();
	}
?>