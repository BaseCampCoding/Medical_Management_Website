var coll = document.querySelectorAll(".collapsible > button")
var i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
        var content = this.nextElementSibling;
        content.classList.toggle("active")

    })
}