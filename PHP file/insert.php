 <?php

$conn=mysqli_connect( "localhost", "id17715437_kushang_patel", "Ksquare@1225");


mysqli_select_db($conn,"id17715437_employee_detail");

    $first_name=$_POST['first_name'];
    $last_name=$_POST['last_name'];
    $designation=$_POST['desigantion'];
    $email=$_POST['email'];
    $date_of_birth=$_POST['date_of_birth'];
    $address=$_POST['address'];
    $department=$_POST['department'];
    
    
   $qry="INSERT INTO 'Employee' ('id', 'first_name', 'last_name', 'designation', 'email', 'date_of_birth', 'address', 'department') VALUES (NULL, '$first_name', $last_name', '$designation', '$email', '$date_of_birth', '$address', '$department')";
   
   mysqli_query($conn, $qry);
    
   echo json_encode(array('response'=>"Inserted Successfully"));
    
?>