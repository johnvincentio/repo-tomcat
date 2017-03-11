var Global = (function() {	
	var showBrowserUpgradeWarning = function() {
		if(herc.browser.upgradeWarningShown == "Y") {return;}  
		//if ( $.browser.mozilla && $.browser.version.slice(0,3) == "1.9" ) {
		//if ($.browser.webkit){ 
		//if (parseInt($.browser.version, 10) <= 7) {
		//IE7 below doesn't have Trident

		if(($.browser.msie && navigator.userAgent.search('Trident') == -1 )) { 
				var warningOverlay = new OverlayBox();
				warningOverlay.reset(); 
			  	warningOverlay.params.center = true;
			  	warningOverlay.params.scroll = false;
			  	warningOverlay.params.screen = 70;  
			  	warningOverlay.params.width = 560;
			  	warningOverlay.params.url = herc.config.rootContext + "/popups/templates/browserUpgradeWarningView.jsp";
			  	warningOverlay.init();
			  	warningOverlay.jspRequest();
				
		}
	};
	$(window).load(function() {	
		showBrowserUpgradeWarning();
	});

})();