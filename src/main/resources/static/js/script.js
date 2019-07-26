function updateFunctionAccessory(accessoryId) {
    var x = document.getElementById("accessoryName" + accessoryId);
    var b = document.getElementById("accessoryNameSave" + accessoryId);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        // request to app to update value for accessory with id accessoryId
        x.style.display = "none";
    }

    if (b.style.display === "none") {
        b.style.display = "block";
    } else {
        // request to app to update value for accessory with id accessoryId
        b.style.display = "none";
    }
}