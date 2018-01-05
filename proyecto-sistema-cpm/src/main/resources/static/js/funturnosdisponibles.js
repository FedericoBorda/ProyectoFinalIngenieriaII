$(function(){
			
			
			$("#comprobar1").click(function(){
				$("#day").val("1");
				$("#hour").val("8");
				buscar($('#year').val(), 
						$('#month').val(), 
						$('#day').val(), 
						$('#hour').val(), 
						$('#check_activado').val(), 
						$('#check_asignado').val())
			
			});
			
			$("#comprobar2").click(function(){
				$("#day").val("1");
				$("#hour").val("9");
				buscar2($('#year').val(), 
						$('#month').val(), 
						$('#day').val(), 
						$('#hour').val(), 
						$('#check_activado').val(), 
						$('#check_asignado').val())
				
			});
			
			function buscar(anio, mes, dia, hora, checkact, checkasig){
				var parametros = {
					"anio":anio,
					"mes":mes,
					"dia":dia,
					"hora":hora,
					"checkact":checkact,
					"checkasig":checkasig
				}
				$.ajax({
					data:parametros,
					url:"/busqueda",
					type:"post",
					beforeSend:function(){
						console.log("Se esta procesando la solicitud...");
					}
				})
				.done(function(data){
					console.log("El resultado de la peticion es: " + data)
					
					if(data === 1){
						alert("Ésta fecha ya fue activada " + data);
						$('#activar1').attr("disabled", true);						
					}else{						
						$('#activar1').attr("disabled", false);						
						//alert("la fecha no exite " + data);
					}
				
				});
			
			}
			
			
			function buscar2(anio, mes, dia, hora, checkact, checkasig){
				var parametros = {
					"anio":anio,
					"mes":mes,
					"dia":dia,
					"hora":hora,
					"checkact":checkact,
					"checkasig":checkasig
				}
				$.ajax({
					data:parametros,
					url:"/busqueda",
					type:"post",
					beforeSend:function(){
						console.log("Se esta procesando la solicitud...");
					}
				})
				.done(function(data){
					console.log("El resultado de la peticion es: " + data)
					
					if(data === 1){
						alert("Ésta fecha ya fue activada " + data);
						$('#activar2').attr("disabled", true);						
					}else{						
						$('#activar2').attr("disabled", false);						
						//alert("la fecha no exite " + data);
					}
				
				});
			
			}
		
		});
	