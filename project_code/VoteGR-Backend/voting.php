<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");

            $citizen_id = $_POST['afm'];
            $choice = $_POST['choice'];

            $todate = date("Y-m-d");
			$sql = "SELECT `voting`.`idvoting`
            FROM `votegr`.`voting` 
            INNER JOIN `vote` ON `voting`.`vote_id` = `vote`.`idvote` 
            WHERE `vote`.`starting_date`<= '$todate' AND `vote`.`ending_date`>= '$todate' AND `voting`.`citizen_id` = '$citizen_id';";

            $stmt = mysqli_query($db, $sql);
            $data = mysqli_fetch_row($stmt);

            if(!$data){
            
                $sql = "SELECT `vote_stats`.`$choice`,`vote_stats`.`idvote_stats`
                FROM `votegr`.`vote_stats` 
                INNER JOIN `vote` ON `vote_stats`.`ref_vote_id` = `vote`.`idvote` 
                WHERE `vote`.`starting_date`<= '$todate' AND `vote`.`ending_date`>= '$todate';";

                $stmt = mysqli_query($db, $sql);
                $data = mysqli_fetch_row($stmt);
                $choice_count = $data[0];
                $idvote = $data[1];
                $choice_count += 1;

                echo $choice_count;

                $sql = "UPDATE `votegr`.`vote_stats`
                SET
                `vote_stats`.`$choice` = '$choice_count'
                WHERE `vote_stats`.`idvote_stats` = $idvote;";
                mysqli_query($db, $sql);

                $sql = "INSERT INTO `votegr`.`voting`
                (
                `citizen_id`,
                `vote_id`)
                VALUES
                (
                '$citizen_id',
                '$idvote'
                );";
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
