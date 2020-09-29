function limpiar(){
    $("#txt_id").val(0);
    $("#txt_producto").val('');
    $("#txt_descripcion").val('');
    $("#txt_costo").val('');
    $("#txt_venta").val('');
    $("#txt_existencias").val('');
    $("#drop_marca").val(1);
}

$('#tbl_productos').on('click', 'tr td', function(evt){
    var target, id, idmarca, producto, descripcion, costo, venta,existencia;

    target = $(event.target);

    id = target.parent().data("id");
    idmarca = target.parent().data("idmarca");
    producto = target.parent("tr").find("td").eq(0).html();
    descripcion = target.parent("tr").find("td").eq(1).html();
    costo = target.parent("tr").find("td").eq(2).html();
    venta = target.parent("tr").find("td").eq(3).html();
    existencia = target.parent("tr").find("td").eq(4).html();

    $("#txt_id").val(id);
    $("#txt_producto").val(producto);
    $("#txt_descripcion").val(descripcion);
    $("#txt_costo").val(costo);
    $("#txt_venta").val(venta);
    $("#drop_marca").val(idmarca);
    $("#txt_existencias").val(existencia);

    $("#addModal").modal('show');


})




