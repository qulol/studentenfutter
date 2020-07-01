function printShoppingList() {
        var mywindow = window.open('', 'PRINT', 'height=600,width=800');

        const content = document.getElementById("printShoppingList").getAttribute("data-content");
        mywindow.document.write(content);

        mywindow.document.close(); // necessary for IE >= 10
        mywindow.focus(); // necessary for IE >= 10*/

        mywindow.print();
}