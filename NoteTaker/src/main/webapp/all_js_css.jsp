       <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css" /> 
   
   
   
   
   
   
   
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.2/mdb.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="//cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        $(document).ready( function () {
         $('#table').DataTable();
        } );
    </script>
   
 
    <script type="text/javascript">
       edits= document.getElementsByClassName("edit");
        Array.from(edits).forEach((element)=>{
            element.addEventListener("click",(e)=>{
                console.log("edit ",);
                tr=e.target.parentNode.parentNode;
                CustomerName=tr.getElementsByTagName("td")[1].innerText;
                Todoitem=tr.getElementsByTagName("td")[2].innerText;
                MobileNumber=tr.getElementsByTagName("td")[3].innerText;
                console.log(CustomerName,Todoitem,MobileNumber);
                CustomerNameEdit.value=CustomerName;
                TodoitemEdit.value=Todoitem;
                MobileNumberEdit.value=MobileNumber;
                $('#editModal').modal('toggle');
            })
        })
    </script>
    
    <script>
    function save() {
		//alert("success");
		swal("Note Saved!", "You clicked the button!", "success");
	}
   
    </script>
    <script>
    function delete1() {
    	/* swal("Are you sure you want to do this?", {
    		  buttons: ["No!", "Yes!"],
    		}); */
    		
    		
    	swal({
    		  title: "Are you sure?",
    		  text: "Once deleted, you will not be able to recover this Note data!!!",
    		  icon: "warning",
    		  buttons: true,
    		  dangerMode: true,
    		})
    		.then((willDelete) => {
    		  if (willDelete) {
    		    swal("Your Note data has been deleted!!!", {
    		      icon: "success",
    		    });
    		  } else {
    		    swal("Your Note data is safe!");
    		  }
    		});
    
    }
    </script>