const userSearch = document.querySelector("[data-search]");

function filter() {
  const term = userSearch.value.toLowerCase();
  const tags = document.querySelectorAll("[data-searchable] .list-item");

  tags.forEach(tag => {
    const itemText = tag.textContent.toLowerCase();
    if (itemText.includes(term)) {
      tag.style.display = "flex";
    } else {
      tag.style.display = "none";
    }
  });
}

userSearch.addEventListener("input", filter);

const recentSearchList = document.querySelector(".recent-search__list");
const clearBtn = document.querySelector(".clear-btn");
const clearSearch = document.querySelector('.search__clear');

clearSearch.addEventListener('click', () => {
  userSearch.value = "";
  filter();
});

userSearch.addEventListener("keydown", event => {
  if (input.key === "Enter") {
    const inputText = userSearch.value.toLowerCase();
    recentSearchList.insertAdjacentHTML(
      "beforeend",
      `<span class="search-item" onclick="labelSearch('${inputText}')">${inputText}<span class="search-item__close">×</span></span>`
    );

    if (recentSearchList.childNodes.length > 0) {
      clearBtn.innerHTML = "Clear Items";
      clearBtn.removeAttribute("disabled");
      const btns = document.querySelectorAll(".search-item__close");

      btns.forEach(btn => {
        btn.addEventListener("click", function(e) {
          e.currentTarget.parentNode.remove();
        });
      });
    }

    userSearch.value = "";
    filter();
  }
});

function labelSearch(x) {
  userSearch.value = x;
  filter();
}

const clearRecent = () => {
  recentSearchList.innerHTML = "";
  clearBtn.setAttribute("disabled", true);
  clearBtn.innerHTML = "No Recent Items";
  userSearch.value = '';
  filter();
};
