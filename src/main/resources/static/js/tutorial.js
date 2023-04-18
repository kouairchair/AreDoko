$(document).ready(() => {

  // 以下のようにDOMの操作（要素の表示/非表示の切り替えや、クリックイベントの設定）の処理や初期化処理などを記述する（実際の処理はできるだけ本ファイル内のメソッドを呼ぶこと）
  $(".btn-delete").on("click", function (e) {
    e.preventDefault();
    tutorial.deleteTutorial($(this));
  });

  $("#btnClear").on("click", function (e) {
    e.preventDefault();
    tutorial.clearKeyword();
  });

  // $("#searchForm").submit(function (e) {
  //   e.preventDefault();
  //   tutorial.searchTutorialFetch(e.target);
  // });

  tutorial.init()
});

// クラスを使ったコードの構造化
class Tutorial {
  constructor() {
    // コンストラクタの処理を記述する
  }

  init() {
    // 初期化処理
  }

  // 以降はメソッドの定義を記述する
  /**
   * チュートリアルの削除処理
   */
  deleteTutorial(link) {
    tutorialTitle = link.attr("tutorialTitle");
    $("#yesBtn").attr("href", link.attr("href"));
    $("#confirmText").html("Do you want to delete the Tutorial \<strong\>" + tutorialTitle + "\<\/strong\>?");
    $("#confirmModal").modal();
  }

  /**
   * キーワード検索のクリア処理
   */
  clearKeyword() {
    $("#keyword").text("");
    window.location = "[[@{/tutorials}]]";
  }

  /**
   * チュートリアルの検索処理
   * TODO: htmlのフォームから直接submitすればよいのだが、JSを介しても動くか確認している
   */
  searchTutorial() {
    $.post("/tutorials", $("#keyword").serialize(), function (response) {
      document.tutorialForm.tutorials = response.tutorials;
    }).fail(function (e) {
      alert("Error!")
      console.log("ERROR: ", e);
    });
  }

  /**
   * チュートリアルの検索処理(fetchメソッドのテスト)
   */
  searchTutorialFetch(target) {
    // Fetchメソッドを使用してフォームのデータをサーバーに送信するリクエストを送信
    fetch('/tutorials', {
      method: 'POST',
      body: new FormData(target)
    })
      .then(function (response) {
        return response.text();
      })
      .then(function (html) {
        // サーバーからのレスポンスを処理
        console.log(html); // someFormにアサインされたHTMLを取得

        // スピナーを非表示にする処理をここに記述
      })
      .catch(function (error) {
        // エラーの処理
        console.error(error);

        // スピナーを非表示にする処理をここに記述
      });
  }

  /**
   * チュートリアルの検索処理(ajaxメソッドのテスト)
   */
  searchTutorialAjax(formData) {
    $.ajax({
      type: "POST",
      url: "/tutorials",
      data: formData,
      success: function (response) {

      },
      error: function (e) {
        alert("Error!")
        console.log("ERROR: ", e);
      },
    });

  }

  /**
   * スピナーの表示処理
   */
  showSpinner() {
    $('#spinner').show();
  }

  /**
   * スピナーの非表示処理
   */
  hideSpinner() {
    $('#spinner').hide();
  }

  /**
   * ページサイズの変更処理
   */
  changePageSize() {
    $("#searchForm").submit();
  }
}

const tutorial = new Tutorial();
