document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("betForm");
  
    form.addEventListener("submit", async function (event) {
      event.preventDefault();
  
      const bettorId = document.getElementById("bettorId").value;
      const stake = parseFloat(document.getElementById("stake").value);
      const betType = document.getElementById("betType").value;
  
      try {
        const response = await fetch("http://localhost:8080/api/place-bet", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ bettorId, stake, betType }),
        });
  
        // Check if the response is successful
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
  
        const result = await response.json();
        console.log("✅ Backend result:", result);
  
        // Show the result
        document.getElementById("resultBox").innerText =
          `Bet Result: ${result.result} | Winnings: $${result.winnings.toFixed(2)} | New Balance: $${result.newBalance.toFixed(2)}`;
  
      } catch (error) {
        console.error("❌ Error placing bet:", error);
        document.getElementById("resultBox").innerText =
          "⚠️ Error placing bet. Check console for details.";
      }
    });
  });
  