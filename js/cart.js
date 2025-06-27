document.addEventListener("DOMContentLoaded", () => {
    const table = document.getElementById("cartTable");
    const totalPriceEl = document.getElementById("totalPrice");
    const resetBtn = document.getElementById("resetCartBtn");

    function updateTotal() {
        let total = 0;
        table.querySelectorAll("tbody tr").forEach(row => {
            total += parseInt(row.dataset.price || "0", 10);
        });
        totalPriceEl.textContent = `￥${total}`;
    }

    table.addEventListener("click", (e) => {
        if (e.target.classList.contains("remove-btn")) {
            e.target.closest("tr").remove();
            updateTotal();
        }
    });

    resetBtn.addEventListener("click", () => {
        table.querySelector("tbody").innerHTML = "";
        updateTotal();
    });

    updateTotal();
});
