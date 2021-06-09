<?php
	define('DB_SERVER', 'localhost:3306');
	define('DB_USERNAME', 'root');
	define('DB_PASSWORD', '');
	define('DB_DATABASE', 'votegr');

	try {
		if ($db = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE)) {
			$db->set_charset("utf8");
        
            $subject = $_POST['subject'];
            $starting_date = $_POST['starting_date'];
            $ending_date = $_POST['ending_date'];

            $sql = "INSERT INTO `votegr`.`vote`
            (
            `subject`,
            `starting_date`,
            `ending_date`)
            VALUES
            (
            '$subject',
            '$starting_date',
            '$ending_date');";

            if($starting_date <= $ending_date){
                mysqli_query($db, $sql);
            }else{
                echo "Λανθασμένη σειρά ημερομηνιών!!!";
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
