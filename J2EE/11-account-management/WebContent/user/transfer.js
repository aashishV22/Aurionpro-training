document.querySelector('button[type="submit"]').addEventListener('click', function(event) {
    event.preventDefault();
    var amount  	  		  = parseInt(document.querySelector('input[name="amount"]').value);
    var receiversAccountNumber= parseInt(document.querySelector('input[name="receiversAccountNumber"]').value);
    var sendersAccountNumber  = parseInt(document.querySelector('input[name="accountNumber"]').value);
    var user_id 	 		  = parseInt(document.querySelector('input[name="userId"]').value);
    var transactioType_id	  = parseInt(document.querySelector('input[name="transactioType_id"]').value);
    var balance 	  		  = parseInt(document.querySelector('input[name="balance"]').value);
    var accountType			  = document.querySelector('input[name="accountType"]').value;

    var winFeature = 'location=no,toolbar=no,menubar=no,scrollbars=yes,resizable=yes';

    if(accountType=="saving")
	{
		if (amount >= balance ) {
	        alert("Amount entered is greater than available balance. Please enter a valid amount.");
	    }else if(temp<=1000){
	        alert("Balance amount of Rs-1000 shold be kept. Please enter a less amount.");
	    }else if (receiversAccountNumber === sendersAccountNumber ) {
	        alert("Account number of Receiver is same as Senders!");
	    }
	    else {
	        window.location.href = "singleUserController?action=transferClicked&amount=" + amount+"&sendersAccountNumber="+sendersAccountNumber+"&receiversAccountNumber="+receiversAccountNumber+"&userId="+user_id+"&transactioType_id="+transactioType_id;
	    }
		
	}else{
		if (amount >= balance ) {
	        alert("Amount entered is greater than available balance. Please enter a valid amount.");
		}else if (receiversAccountNumber === sendersAccountNumber ) {
	        alert("Account number of Receiver is same as Senders!");
	    }
		else {
		      window.location.href = "singleUserController?action=transferClicked&amount=" + amount+"&sendersAccountNumber="+sendersAccountNumber+"&receiversAccountNumber="+receiversAccountNumber+"&userId="+user_id+"&transactioType_id="+transactioType_id;
	    }
	}
    
    
    
});
