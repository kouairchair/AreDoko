$(document).ready(() => {

  // ページサイズの変更処理
  $("#pageSize").change(function () {
    changePageSize();
  });

  $(".btn-delete").on("click", function (e) {
    e.preventDefault();
    home.deleteItem($(this));
  });

  $("#btnClear").on("click", function (e) {
    e.preventDefault();
    home.clearKeyword();
  });

  home.init()
});

// クラスを使ったコードの構造化
class Home {
  constructor() {
    // コンストラクタの処理を記述する
  }

  init() {
    // 初期化処理
  }

  /**
 * チュートリアルの削除処理
 */
  deleteItem(link) {
    itemName = link.attr("itemTitle");
    $("#yesBtn").attr("href", link.attr("href"));
    $("#confirmText").html("Do you want to delete the Item \<strong\>" + itemName + "\<\/strong\>?");
    $("#confirmModal").modal();
  }

  /**
   * キーワード検索のクリア処理
   */
  clearKeyword() {
    $("#keyword").text("");
    window.location = "[[@{/items}]]";
  }

  /**
   * ページサイズの変更処理
   */
  changePageSize() {
    $("#searchForm").submit();
  }
};

const home = Home();
