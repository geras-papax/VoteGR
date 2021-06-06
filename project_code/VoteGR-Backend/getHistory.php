<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', 'pao134ever');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");

			$todate = date("Y-m-d");
			$sql = "SELECT `vote`.`subject`,
			`vote_stats`.`yes`,
			`vote_stats`.`no`,
			`vote_stats`.`white`
			FROM `votegr`.`vote_stats`
			INNER JOIN `vote` ON `vote_stats`.`ref_vote_id` = `vote`.`idvote`;";
			

			$stmt = mysqli_query($db, $sql);
			
			while($row = mysqli_fetch_assoc($stmt))
			{
				echo json_encode($row, JSON_UNESCAPED_UNICODE);
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
