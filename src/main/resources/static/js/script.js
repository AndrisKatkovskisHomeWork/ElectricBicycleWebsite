function updateFunctionAccessory(accessoryId) {
    var x = document.getElementById("accessoryName" + accessoryId);
    var b = document.getElementById("accessoryNameSave" + accessoryId);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }

    if (b.style.display === "none") {
        b.style.display = "block";
    } else {
        b.style.display = "none";
    }
}