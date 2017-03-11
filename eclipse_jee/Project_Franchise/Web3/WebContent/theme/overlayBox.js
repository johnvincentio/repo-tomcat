var OverlayBox = function() {
	this.params = {};
	OverlayBox.OVERLAYSEQUENCE += 1;
	
	this.setDefaults();
	this.params.container = "overlayBox_"+OverlayBox.OVERLAYSEQUENCE;
	this.params.zIndex = this.params.zIndex + (OverlayBox.OVERLAYSEQUENCE * 5);
};

OverlayBox.OVERLAYSEQUENCE = 0;

OverlayBox.prototype.setDefaults = function() {	
	this.params.url 	= "";
	this.params.top 	= 100;		
	this.params.left 	= 100;	
	this.params.width 	= 400;
	this.params.border 	= 5;		
	this.params.center 	= true;		
	this.params.vCenter	= false;
	this.params.scroll 	= true;
	this.params.screen 	= 40;		
	this.params.dismiss = true;
	this.params.event 	= {};
	this.params.menu    = { top : false, bottom : true};
	this.params.zIndex  = 1050;
	this.params.isActive = false;
	this.params.onClose = null;
	this.params.container = "";	
};

OverlayBox.prototype.reset = function() {
	var containerId = this.params.container;
	var zIndex = this.params.zIndex;
	
	this.setDefaults();
	this.params.container = containerId;
	this.params.zIndex = zIndex;
};

OverlayBox.prototype.execFailure = function() {	
	$("#"+this.params.container+" .lbFgContentBox").html( herc.content.ajaxFail );			
};

OverlayBox.prototype.execComplete = function(req) {	
	this.show();
};

OverlayBox.prototype.initOverlaySkeleton = function() {
	var b = [];
	b.push('<div id="'+this.params.container+'">');
	b.push('  <div class="lbBgScreen" style="z-index:'+this.params.zIndex+';"></div>');	
	b.push('  <div class="lbFgBox" style="z-index:'+(this.params.zIndex+1)+';">');
	
	if(this.params.menu.top) {
		b.push('<div class="lbClose lbCloseContTop"><span class="lbCloseLabel">'+herc.content.close+'</span><span class="lboxCloseX">&nbsp; &nbsp; &nbsp;</span></div>');
	}
	
	b.push('<div class="lbFgContentBox"></div>');
	
	if(this.params.menu.bottom) {
		b.push('<div class="lbClose lbCloseContBottom"><span class="lbCloseLabel">'+herc.content.close+'</span><span class="lboxCloseX">&nbsp;&nbsp;&nbsp;</span></div>');
	}
	
	b.push('</div>');
	b.push('</div>');
	buf = b.join("");
	
	$(".tmplPageContainer").after(buf);
};

OverlayBox.prototype.jspRequest = function() {
	var self = this;	
	$.ajax({
		type	: "post",
		url		: this.params.url,
		success	: function(req){$("#"+self.params.container+" .lbFgContentBox").html( req );},
		error	: this.execFailure,			
		complete: function(req) { 
			self.execComplete(req); 
			if (typeof self.params.event == 'function') {
				self.params.event();
			}
		}			
	});
};

OverlayBox.prototype.hide = function () {
	var self = this;
	Utils.showSelects();	
	$("#"+self.params.container+" .lbFgBox").hide();
	$("#"+self.params.container+" .lbBgScreen").hide();
	
	$(window).unbind( "resize" );
	$(window).unbind( "scroll" );		
	$("#"+self.params.container+" .lbBgScreen").unbind( "click" );				
	$(document).unbind( "keyup" );
	
	this.params.isActive = false;
};

OverlayBox.prototype.show = function () {
	Utils.hideSelects();		
	Utils.alpha($("#"+this.params.container+" .lbBgScreen").get()[0], this.params.screen);
	$("#"+this.params.container+" .lbBgScreen").show();
	$("#"+this.params.container+" .lbFgBox").show(); 
	this.params.isActive = true;
};

OverlayBox.prototype.setPosition = function() {
	var dim = Utils.getDimensions();
	var posLeft = Math.round ( ( ( dim[1] - this.params.width ) / 2 ) );
	var t = ( this.params.scroll || this.params.vCenter ) ? ( dim[2] + 100 ) : this.params.top;		
	var l = ( this.params.center ) ? posLeft : this.params.left;		
	$("#"+this.params.container+" .lbBgScreen").css( { "width" : dim[1], "height" : dim[0]  } );
	$("#"+this.params.container+" .lbFgBox").css( { "width" : this.params.width , "top" : t,  "left" : l } );		
};

OverlayBox.prototype.showRequest = function() {
	var el = ( typeof this.params.url == "string" ) ? $("#"+this.params.url).get(0) : this.params.url;		
	$("#"+this.params.container+" .lbFgContentBox").html ( el.innerHTML );
	this.show();
};

OverlayBox.prototype.showContent = function() {
	$("#"+this.params.container+" .lbFgContentBox").html ( this.params.url );
	this.show();
};

OverlayBox.prototype.init =	function () {
	var self = this;
	if($("#"+this.params.container).length == 0) this.initOverlaySkeleton();
	else {
		if(self.params.menu.bottom) {
			if($("#"+self.params.container+" .lbCloseContBottom").length<1)
				$('#'+self.params.container+' .lbFgBox').append('	  <div class="lbClose lbCloseContBottom"><span class="lbCloseLabel">'+herc.content.close+'</span><span class="lboxCloseX">&nbsp; &nbsp; &nbsp;</span></div>');
				
			$("#"+self.params.container+" .lbCloseContBottom").show();
		}
		else $("#"+self.params.container+" .lbCloseContBottom").hide();
	}

	if ( this.params.center )  $(window).bind("resize",	function(e) { self.setPosition(); } ); 
	if ( this.params.scroll )  $(window).bind("scroll" , function(e) { self.setPosition(); } ); 
	if ( this.params.dismiss ) $(document).bind("keyup", function(e){ if( e.keyCode == 27 ) self.hide(); }	); 

	if ( this.params.dismiss ) {
		$("#"+self.params.container+" .lbBgScreen").addClass("lbClose");	
	} else {
		$("#"+self.params.container+" .lbBgScreen").removeClass("lbClose");
	}

	$("#"+self.params.container+" .lbClose").bind("click", function(e) {
		if(typeof self.params.onClose == 'function') self.params.onClose();
		self.hide();
	});
	
	$("#"+self.params.container+" .lbFgBox").css("padding", self.params.border+"px");
	if(this.params.menu.top) {
		$("#"+self.params.container+" .lbCloseContTop").css("margin-bottom", self.params.border+"px");
	}
	if(this.params.menu.bottom) {
		$("#"+self.params.container+" .lbCloseContBottom").css("margin-top", self.params.border+"px");
	}

	self.setPosition();
};

