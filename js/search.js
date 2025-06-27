document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("searchForm");
  const popup = document.getElementById("popup");
  const popupContent = document.getElementById("popupContent");
  const closeBtn = document.getElementById("closeBtn");

  form.addEventListener("submit", (e) => {
    e.preventDefault(); // フォーム送信を止める

    const query = form.query.value;
    const type = form.type.value;

    fetch(`views/music/searchForm?query=${encodeURIComponent(query)}&type=${encodeURIComponent(type)}`)
      .then(response => response.json())
      .then(data => {
        // JSONを解析して結果表示
        if (data.length === 0) {
          popupContent.textContent = "検索結果がありません。";
        } else {
          let html = "<ul>";
          if (type === "title") {
            data.forEach(item => {
              html += `<li>タイトル: ${item.title}, アーティスト: ${item.artistName}</li>`;
            });
          } else if (type === "artist") {
            data.forEach(item => {
              html += `<li>アーティスト: ${item.name}</li>`;
            });
          }
          html += "</ul>";
          popupContent.innerHTML = html;
        }
        popup.classList.remove("hidden");
      })
      .catch(error => {
        popupContent.textContent = "エラーが発生しました。";
        popup.classList.remove("hidden");
        console.error(error);
      });
  });

  closeBtn.addEventListener("click", () => {
    popup.classList.add("hidden");
  });
});
