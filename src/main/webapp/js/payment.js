//document.addEventListener("DOMContentLoaded", () => {
//    const paymentSelect = document.getElementById("paymentMethod");
//    const totalAmountEl = document.getElementById("totalAmount");
//
//    // 合計金額を計算
//    function updateTotal() {
//        let baseTotal = 0;
//        const priceTds = document.querySelectorAll("tbody td:first-child");
//        priceTds.forEach(td => {
//            baseTotal += parseInt(td.textContent.replace("￥", ""));
//        });
//
//        const method = paymentSelect.value;
//        if (method === "convenience") {
//            baseTotal += 300; // 手数料
//        }
//
//        totalAmountEl.textContent = `￥${baseTotal}`;
//    }
//
//    paymentSelect.addEventListener("change", updateTotal);
//    updateTotal(); // 初期表示
//});

document.addEventListener("DOMContentLoaded", function () {
    const baseTotal = parseInt(document.getElementById("baseTotal").value);
    const paymentSelect = document.getElementById("paymentMethod");
    const totalDisplay = document.getElementById("totalAmount");
	
	console.log("start" + paymentSelect.value)
	if (typeof sessionPaymentMethod !== "undefined" && sessionPaymentMethod) {
	    paymentSelect.value = sessionPaymentMethod;
	}

    function updateTotal() {
        let fee = 0;
		console.log("select" + paymentSelect.value)
        if (paymentSelect.value === "convenience") {
            fee = 300;
        }
		console.log("updateTotal" + fee)
        totalDisplay.textContent = "￥" + (baseTotal + fee);
		
    }

    paymentSelect.addEventListener("change", updateTotal);
    updateTotal(); // 初期表示
	
	
});

//document.addEventListener("DOMContentLoaded", function (){
//	const baseTotal = parseInt(document.getElementById("baseTotal").value);
//	const paymentSelect = document.getElementById("paymentMethod");
//	const totalDisplay = document.getElementById("totalAmount");
//
//	console.log("start" + paymentSelect.value)
//	if (typeof sessionPaymentMethod !== "undefined" && sessionPaymentMethod) {
//		paymentSelect.value = sessionPaymentMethod;
//	}
//
//		let fee = 0;
//		console.log("select" + paymentSelect.value)
//		if (paymentSelect.value === "convenience") {
//			fee = 300;
//		}
//		console.log("updateTotal" + fee)
//		totalDisplay.textContent = "￥" + (baseTotal + fee);
//
//	paymentSelect.addEventListener("change", updateTotal);
//	updateTotal(); // 初期表示
//
//});

