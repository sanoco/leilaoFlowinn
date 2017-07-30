


function caixaAlta(formName, fieldName){
  var vr = "";
  vr = document.forms[formName].elements[fieldName].value; 
  var temp = vr.toUpperCase();
  temp = temp.replace('Á','A').replace('À','A').replace('Ã','A').replace('Â','A');
  temp = temp.replace('É','E').replace('È','E').replace('Ê','E');
  temp = temp.replace('Í','I').replace('Ì','I').replace('Î','I');
  temp = temp.replace('Ó','O').replace('Ò','O').replace('Ô','O').replace('Õ','O');
  temp = temp.replace('Ú','U').replace('Ù','U').replace('Û','U').replace('Ü','U');
  temp = temp.replace('Ç','C');
  document.forms[formName].elements[fieldName].value = temp;
  return true;
}  

function caixaBaixa(formName, fieldName){
  var vr = "";
  vr = document.forms[formName].elements[fieldName].value; 
  document.forms[formName].elements[fieldName].value = vr.toLowerCase();
  return true;
} 


// retira caracteres invalidos da string
function Limpar(valor, validos) {
	var result = "";
	var aux;
	for (var i=0; i < valor.length; i++) {
		aux = validos.indexOf(valor.substring(i, i+1));
		if (aux>=0) {
			result += aux;
		}
	}
	return result;
}

function FormataCasasDecimasInferior(campo,decimal){
	var campo_size = campo.value.length;
	if (campo_size==0){
		return;
	}
	if (campo_size<=decimal){
		for (var i=0; i < decimal; i++) {
			if (i==0){
				campo.value=campo.value+',';
			}
			campo.value=campo.value+'0';
		}
	}
}

//Formata número tipo moeda usando o evento onKeyDown
function Formata(campo,tammax,teclapres,decimal) {
	tammax=20;
	var tecla = teclapres.keyCode;
	vr = Limpar(campo.value,"0123456789");
	tam = vr.length;
	dec=decimal
	
	if (tam < tammax && tecla != 8){
		tam = vr.length + 1 ; 
	}
	
	if (tecla == 8 ){
		tam = tam - 1 ; 
	}
	
	if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
		if ( tam <= dec )	{
			campo.value = vr ; 
		}
	
		if ( (tam > dec) && (tam <= 5) ){
			campo.value = vr.substr( 0, tam - 2 ) + "," + vr.substr( tam - dec, tam ) ; 
		}
		if ( (tam >= 6) && (tam <= 8) ){
			campo.value = vr.substr( 0, tam - 5 ) + "" + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ; 
		}
		if ( (tam >= 9) && (tam <= 11) ){
			campo.value = vr.substr( 0, tam - 8 ) + "" + vr.substr( tam - 8, 3 ) + "" + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ; 
		}
		if ( (tam >= 12) && (tam <= 14) ){
			campo.value = vr.substr( 0, tam - 11 ) + "" + vr.substr( tam - 11, 3 ) + "" + vr.substr( tam - 8, 3 ) + "" + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - dec, tam ) ; 
		}
		if ( (tam >= 15) && (tam <= 17) ){
			campo.value = vr.substr( 0, tam - 14 ) + "" + vr.substr( tam - 14, 3 ) + "" + vr.substr( tam - 11, 3 ) + "" + vr.substr( tam - 8, 3 ) + "" + vr.substr( tam - 5, 3 ) + "," + vr.substr( tam - 2, tam ) ;
		}
	} 
}


//Máscara para CPF e CNPJ
function MascaraRegistro(campo,proximoCampo) {
	var tam = campo.value.length;
	var str = campo.value;
	if ((str.indexOf('.')==-1)&&(str.indexOf('-')==-1)){
		if (tam==11){ // CPF
			campo.value  = str.substring(0,3)+'.'+str.substring(3,6)+'.'+str.substring(6,9)+'-'+str.substring(9,11);
		}
		else if (tam==14){ // CNPJ
			campo.value  = str.substring(0,2)+'.'+str.substring(2,5)+'.'+str.substring(5,8)+'/'+str.substring(8,12)+'-'+str.substring(12,14);
		}
	}
	if (proximoCampo!=null){
		proximoCampo.focus();	
	}
}

//caso o campo tenha o número de caracteres especificado, pula para o próximo campo
function proximoCampo(campo,proximoCampo,tamanho) {
	var tam = campo.value.length;
	if (tam==tamanho){ 
		if (proximoCampo!=null){
			proximoCampo.focus();	
		}
	}
}

//Máscara para CEP
function MascaraCEP(campo,proximoCampo) {
	var tam = campo.value.length;
	var str = campo.value;
	if (str.indexOf('-')==-1){
		if (tam==8){
			campo.value  = str.substring(0,5)+'-'+str.substring(5,8);
		}
	}
	proximoCampo.focus();	
}

function autoCompletaIE(campo,proximoCampo,teclapres) {
	var tam = campo.value.length;
	var tecla = teclapres.keyCode;
	if (tam==1){
		if (tecla==73){
			campo.value = "ISENTO";
			proximoCampo.focus();
		}
		if (tecla==69){
			campo.value = "EM ANDAMENTO";
			proximoCampo.focus();
		}
	}
}


//Máscara para Data
function MascaraData(campo,proximoCampo) {
	var tam = campo.value.length;
	var str = campo.value;
	if (str.indexOf('/')==-1){
		if (tam==8){
			campo.value  = str.substring(0,2)+'/'+str.substring(2,4)+'/'+str.substring(4,8);
		}
	}
	if (proximoCampo!=null){
		proximoCampo.focus();	
	}
}

//Máscara para Hora
function MascaraHora(campo,proximoCampo) {
	var tam = campo.value.length;
	var str = campo.value;
	if (str.indexOf(':')==-1){
		if (tam==6){
			campo.value  = str.substring(0,2)+':'+str.substring(2,4)+':'+str.substring(4,6);
		}
	}
	if (proximoCampo!=null){
		proximoCampo.focus();	
	}
}

function manageDiv(div,img){
		var isVisible = isDivVisible(div);
		if (div!=null){
			if (!isVisible){
				showDiv(div);
				showArrow(img);
			}else{
				hideDiv(div);
				hideArrow(img);
			}
		}
}

function isDivVisible(div){
	    if (div==null){
	    	return false;
	    }
		var retorno = false;
		if(document.layers){ 
	         retorno = (div.visibility == "show");
	          
	    }else{
	    	 retorno = (div.style.visibility == "visible") && 
	         	       (div.style.display=="block");
	    }
	    return retorno;
}

	function hideDiv(div){
		if(document.layers){ 
	         div.visibility = "hidden";
	    }else{ 	
	         div.style.visibility = "hidden";
	         div.style.display="none";
	    }
	}
	
	function showDiv(div){
		if(document.layers){ 
	         div.visibility = "show"; 
	    }else{ 
	         div.style.visibility = "visible"; 
	         div.style.display="block";                
	    }
	}
	function hideArrow(img){
		var imagem = document.images[img];
		imagem.src = "images/showarrow.gif"
	}
	
	function showArrow(img){
		var imagem = document.images[img];	
		imagem.src = "images/hidearrow.gif"
	}

	
/**
 * Fecha o popup.
 */
 function closeWindow() {
	//Verifica se existe a funcao onPopupClose na pagina chamadora e ja a invoca
	
	if (typeof window.opener.onPopupClose == 'function' || typeof window.opener.onPopupClose == 'object') {
	   window.opener.onPopupClose()
	}
	
    this.close();
 }
 /**
 * Abre um pop-up.
 */
 function openModalWin(url,width,height,resize,status,scrollbar) {
 	 if  (resize == null)
 	   resize = "no";
 	 if  (status == null)
 	   status = "yes";
 	 if  (scrollbar == null)
 	   scrollbar = "no";
    if (url != '') {
		 if(window.showModalDialog){
		    window.showModalDialog( url, self, "center:yes; help:no; status:" + status + "; resize:" + resize + "; dialogHeight:"+ height +"px; dialogWidth:"+ width +"px;" );
		 }else{
		 	 var win = window.open(url,"","height="+ height +",width="+ width +",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable="+resize+",scrollbars="+ scrollbar +",status="+status+",titlebar=yes,toolbar=no", false, 'dialog');		 
		 	 win.focus();
		 }
	    
		 
	 }
 }
 
 
 /**
 * Abre um pop-up.
 */
 function openWin(url,width,height,resize,status,scrollbar) {
 	 if  (resize == null)
 	   resize = "no";
 	 if  (status == null)
 	   status = "yes";
 	 if  (scrollbar == null)
 	   scrollbar = "no";
    if (url != '') {
		 	 var win = window.open(url,"","height="+ height +",width="+ width +",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable="+resize+",scrollbars="+ scrollbar +",status="+status+",titlebar=yes,toolbar=no", false, 'dialog');		 
		 	 win.focus();
	 }
 } 
 

 	

//adiciona mascara ao telefone
function MascaraTelefone(tel,event){

	if(mascaraInteiro(tel)==false){
	event.returnValue = false;
	} else {
		if (tel.value.length>0) {
			return formataCampo(tel, '(00)0000-0000', event);
		} else {
			return;
		}
	}

}

//valida telefone
function ValidaTelefone(tel){

/*
exp = /\(\d{2}\)\d{4}\-\d{4}/
if(!exp.test(tel.value))
alert('Numero de Telefone Invalido:' + tel.value);
tel.value = '';
tel.focus();
*/
}

//valida numero inteiro com mascara
function mascaraInteiro(event){
if (event.keyCode < 48 || event.keyCode > 57){
event.returnValue = false;
return false;
}
return true;
}
//formata de forma generica os campos
function formataCampo(campo, Mascara, evento) {
var boleanoMascara;

var Digitato = evento.keyCode;
exp = /\-|\.|\/|\(|\)| /g
campoSoNumeros = campo.value.toString().replace( exp, "" );

var posicaoCampo = 0;
var NovoValorCampo="";
var TamanhoMascara = campoSoNumeros.length;;

if (Digitato != 8) { // backspace
for(i=0; i<= TamanhoMascara; i++) {
boleanoMascara = ((Mascara.charAt(i) == "-") || (Mascara.charAt(i) == ".")
|| (Mascara.charAt(i) == "/"))
boleanoMascara = boleanoMascara || ((Mascara.charAt(i) == "(")
|| (Mascara.charAt(i) == ")") || (Mascara.charAt(i) == " "))
if (boleanoMascara) {
NovoValorCampo += Mascara.charAt(i);
TamanhoMascara++;
}else {
NovoValorCampo += campoSoNumeros.charAt(posicaoCampo);
posicaoCampo++;
}
}
campo.value = NovoValorCampo;
return true;
}else {
return true;
}
}

function onlyNumeric(txb) {
	   txb.value = txb.value.replace(/[^\0-9]/ig, "");
}

function submitForm(formName){
	var nome = document.getElementById('nome');
	if (nome.value!=''){
		var action = document.getElementById('action');
		action.value='reload';
		
		var form = document.forms[formName];
		form.submit();
	}
	
}

function submitFormAction(formName,action){
	var form = document.forms[formName];
	form.action=action;
	form.submit();
	
}

	

	