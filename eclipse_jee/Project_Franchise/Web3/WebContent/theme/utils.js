
var Utils = (function() {

	return {

		alpha: function(obj, objopacity){
			//style = obj.style
			//style.opacity = style.MozOpacity = style.KhtmlOpacity = opacity / 100
			//style.filter = "alpha(opacity=" + opacity + ")"
			alphaopacity = "alpha(opacity=" + objopacity + ")";
			$(obj).css({ opacity: objopacity/100 });
			$(obj).css("filter", alphaopacity);
		},
		
		getDimensions: function() {
	
			db = document.body;
			de = document.documentElement;
	
			screenH = ( de.clientHeight > db.scrollHeight ) ? de.clientHeight : db.scrollHeight;
			screenW = ( db.clientWidth > db.scrollWidth ) ? db.clientWidth : db.scrollWidth;
			scrollOffset = ( de.scrollTop > db.scrollTop ) ? de.scrollTop : db.scrollTop;
			acceptableW = ( db.clientWidth > 1000 ) ? 1000 : db.clientWidth;
	
			return([screenH,screenW,scrollOffset,acceptableW]);
	
		},			
		
		hideSelects: function() {
			if ($.browser.msie && $.browser.version=="6.0") {
				$("select").each(function(i,o){ if(!$(this).hasClass('noHide')) $(o).css( { 'visibility' : 'hidden' } ); 	 });
				if ($("#lboxDivLBContent")) $("#lboxDivLBContent select").each(function(i,o){ if(!$(this).hasClass('noHide')) $(o).css( { 'visibility' : 'visible' } );  });			
			}			
		},
			
		showSelects: function() {
			if ($.browser.msie && $.browser.version=="6.0") {
				$("select").each(function(i,o){ $(o).css( { 'visibility' : 'visible' } ); 	 })	;
			}
		},
		
		isHexColorCode : function(colorCode) {
			var regColorcode  = /^#[0-9a-f]{3}([0-9a-f]{3})?$/i;
			return regColorcode.test(colorCode);
		},
		
		processKeydown : function(el, e) { 
			if(e.keyCode == '13'){ $(el).click(); } 
		}
	};

})();	
	
