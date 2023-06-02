console.log("js 호출 테스트");
var main = {
  init: function () {
    var _this = this;
    $("#btn-save").click(function () {
      _this.save();
    });
    $("#btn-update").click(function () {
      _this.update();
    });
    $("#btn-delete").click(function () {
      _this.delete();
    });
  },
  save: function () {
    var data = {
      title: $("#title").val(),
      author: $("#author").val(),
      content: $("#content").val(),
    };

    $.ajax({
      type: "post",
      url: "/api/v1/post",
      dataType: "json",
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(data),
    })
      .done(function () {
        alert("글이 등록되었습니다");
        window.location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
  update: function () {
    var data = {
      title: $("#title").val(),
      content: $("#content").val(),
    };

    $.ajax({
      type: "put",
      url: "/api/v1/post/" + $("#id").val(),
      dataType: "json",
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(data),
    })
      .done(function () {
        alert("글이 수정되었습니다");
        window.location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
  delete: function () {
    $.ajax({
      type: "delete",
      url: "/api/v1/post/" + $("#id").val(),
      dataType: "json",
      contentType: "application/json; charset=utf-8",
    })
      .done(function () {
        alert("글이 삭제되었습니다");
        window.location.href = "/";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
};
main.init();
