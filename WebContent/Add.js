function addbox(){
		const option=document.getElementById("select");
		var val=option.value;
		if(val === "HR")
		   document.getElementById("label").innerText="Enter Commission";
		else if(val==="Admin")
			 document.getElementById("label").innerText="Enter Allowance";
		else
			document.getElementById("label").innerText="Enter Incentives";
	}
