<html>
<head>
<title>Grid computing</title>
<script type="text/javascript" src="/jsGrid/dwr/engine.js"></script>
<script type="text/javascript" src="/jsGrid/dwr/util.js"></script>
<script type="text/javascript" src="/jsGrid/dwr/interface/dwrService.js"></script>
<script type="text/javascript" src="/jsGrid/js/jq.js"></script>


<script>
	function startNode() {
		callTime = new Date().getTime();
		dwrService.getPage({
			callback : processHTML
		});
	}

	function processHTML(page) {

		startProcessingTime = new Date().getTime();
		$('#bufHtml')[0].innerHTML = "";
		page.source = page.source.replace(/<head>.*<\/head>/, "");
		page.source = page.source.replace(/<link.*?>/g, "");
		page.source = page.source.replace(/<script.*?\/script>/g, "");
		page.source = page.source.replace(/src=.*?"/g, "src=''");
		page.source = page.source.replace(/src=.*?'/g, "src=''");
		page.source = page.source.replace(/style=.*?'/g, "src=''");
		page.source = page.source.replace(/style=.*?"/g, "src=''");
		page.source = page.source.replace(/href="javascript:.*?"/g, "");
		page.source = page.source.replace(/href='javascript:.*?'/g, "");
		$('#bufHtml')[0].innerHTML = page.source;
		$('#url')[0].value = (page.url);
		var response = new Object();
		response.url = page.url;
		response.urls = getURLs(page.url);

		//get Content worlds
		//return results 
		currentTime = new Date();
		var processingTime = currentTime.getTime() - startProcessingTime;
		var totalTime = currentTime.getTime() - callTime;
		$("#console")[0].value += "\n " + currentTime;
		$("#console")[0].value += "\n Request Processed " + page.url;
		$("#console")[0].value += response.urls.length + " links found.";
		$("#console")[0].value += " Time for processing = " + processingTime;
		$("#console")[0].value += "\n Total time = " + totalTime;
		$('#bufHtml')[0].innerHTML = "";

		callTime = currentTime;
		dwrService.setResponse(response, {
			callback : processHTML
		});
	}

	if (typeof String.prototype.startsWith != 'function') {
		String.prototype.startsWith = function(str) {
			return this.indexOf(str) == 0;
		};
	}

	function getURLs(parent) {
		locationUrl = location.href.replace("index.html", "");
		locationDomain = location.origin;
		aElements = $("a");
		len = aElements.length;
		hrefListUnique = new Array();
		hrefList = new Array(len);
		for ( var i = 0; i < len; ++i) {
			hrefList[i] = aElements[i].href.replace(/#.*/, "");
			if (hrefList[i].startsWith(locationUrl)) {
				hrefList[i] = hrefList[i].replace(locationUrl, parent);
			} else if (hrefList[i].startsWith(locationDomain)) {
				hrefList[i] = hrefList[i].replace(locationDomain + "/", parent);
			}
			hrefListUnique = jQuery.unique(hrefList);
		}
		return hrefListUnique;
	}
</script>
</head>
<body>
    <b onclick="startNode(); return false;">Process Page</b>
    <br />
    <input id="url" type="text"></input>
    <textarea id="console" style="width: 735px; height: 311px;"></textarea>
    <div id="bufHtml"></div>
</body>
</html>