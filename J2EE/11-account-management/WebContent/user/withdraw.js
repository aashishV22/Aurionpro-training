document.querySelector('button[type="submit"]').addEventListener('click', function(event) {
    event.preventDefault();
    var amount  	  = parseInt(document.querySelector('input[name="amount"]').value);
    var balance 	  = parseInt(document.querySelector('input[name="balance"]').value);
    var accountNumber = parseInt(document.querySelector('input[name="accountNumber"]').value);
    var user_id 	  = parseInt(document.querySelector('input[name="userId"]').value);
    var accountType	  = document.querySelector('input[name="accountType"]').value;
    var transactioType_id= parseInt(document.querySelector('input[name="transactioType_id"]').value);
    console.log(accountType)
    var temp= balance - amount ;
	if(accountType=="saving")
	{
		if (amount >= balance ) {
	        alert("Amount entered is greater than available balance. Please enter a valid amount.");
	    }else if(temp<=1000){
	        alert("Balance amount of Rs-1000 shold be kept. Please enter a less amount.");
	    }else {
	        window.location.href = "singleUserController?action=withdrawClicked&amount=" + amount+"&accountNumber="+accountNumber+"&user_id="+user_id+"&transactioType_id="+transactioType_id;
	    }
		
	}else{
		if (amount >= balance ) {
	        alert("Amount entered is greater than available balance. Please enter a valid amount.");
		}else {
	        window.location.href = "singleUserController?action=withdrawClicked&amount=" + amount+"&accountNumber="+accountNumber+"&user_id="+user_id+"&transactioType_id="+transactioType_id;
	    }
	}
    
});
