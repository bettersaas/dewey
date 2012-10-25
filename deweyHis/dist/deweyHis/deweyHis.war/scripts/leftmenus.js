
	// -------------------------------------------------------------
	// Client-side global variables
	// -------------------------------------------------------------

	var sOpenMenuID = "";

	var iChunk = 0;
	var iChunkStep = 15;
	var iChunkDelay = 0;

	//var sMenuPos = "right";   // values: "right", "below"
	var sMenuPos = "below";   // values: "right", "below"
	//var sMenuStyle = "down";	// values: "down", "across", "diagonal"
	var sMenuStyle = "diagonal";	// values: "down", "across", "diagonal"

/* ----------------------------------------------------------------
   main function, doMenu, that hides any open pop-up menus, determines
   which menu DIV to access, and starts its display
	---------------------------------------------------------------- */

	function DoMenu()
	{

		window.event.cancelBubble = true;
		var eSrc = window.event.srcElement;
		// ----------------------------------------------------------
		// If we have a menu open, close it
		// ----------------------------------------------------------

		if ("object" == typeof(document.all[sOpenMenuID]))
		{
			document.all[sOpenMenuID].style.visibility = "hidden";

			// ----------------------------------------------------------
			// If the menu open is the one whose title we click then bail
			// ----------------------------------------------------------

			if (sOpenMenuID == eSrc.id.replace("menu","divmenu"))
			{
				sOpenMenuID = "";
				return false;
			}
			else
			{
				sOpenMenuID = "";
			}
		}

		// ----------------------------------------------------------
		// If a menu title (other than that of an open menu) was clicked
		// ----------------------------------------------------------
		if ("mainmenuitemnormal" == eSrc.className)
		{

		// ----------------------------------------------------------
		// Cancel default link behavior
		// ----------------------------------------------------------

			window.event.returnValue = false;

		// ----------------------------------------------------------
		// Get Menu associated with the Menu Title and make sure it exists
		// If it does, show the Menu
		// ----------------------------------------------------------

			sOpenMenuID = eSrc.id.replace("menu","divmenu")
			if ("object" == typeof(document.all[sOpenMenuID]))
			{
				var eMenu = document.all[sOpenMenuID];
				iChunk = iChunkStep;

				// ----------------------------------------------------------
				// Get the offset of the parent TR and TABLE for positioning the Menu
				// ----------------------------------------------------------

				var eTR = eSrc.parentElement.parentElement
				var eTABLE = eTR.parentElement;

				// ----------------------------------------------------------
				// Set the right and top offsets based on sMenuPos
				// ----------------------------------------------------------

				if ("right" == sMenuPos)
				{
					eMenu.style.left = eTABLE.offsetLeft + eSrc.width;
					eMenu.style.top = eTABLE.offsetTop + eTR.offsetTop;
				}
				else
				{
					eMenu.style.left = eTABLE.offsetLeft + 10;
					//eMenu.style.top = eTABLE.offsetTop + eTR.offsetTop;
					eMenu.style.top = eTABLE.offsetTop + eTR.offsetTop + 20;

				}

				// ----------------------------------------------------------
				// Zero out the Menu size and start the ShowMenu process
				// ----------------------------------------------------------

				eMenu.style.clip = "rect(0 0 0 0)";
				eMenu.style.visibility = "visible";
				return window.setTimeout("ShowMenu(" + eMenu.id + ")", iChunkDelay);
			}
		}
	}

	// ----------------------------------------------------------
	// Function which returns the appropriate menu diplay animation
	// ----------------------------------------------------------

	function GetShowStyle() {
		if ("down" == sMenuStyle) return "rect(0 100% " + iChunk + "% 0)";
		if ("across" == sMenuStyle) return "rect(0 " + iChunk + "% 100% 0)";
		if ("diagonal" == sMenuStyle) return "rect(0 " + iChunk + "% " + iChunk + "% 0)";
		else return "rect(0 100% " + iChunk + "% 0)";
	}

	// ----------------------------------------------------------
	// Function which incrementally displays Menu in appropriate style
	// ----------------------------------------------------------

	function ShowMenu(eMenu) {
		eMenu.style.clip = GetShowStyle();
		if (100 >= iChunk) {
			window.setTimeout("ShowMenu(" + eMenu.id + ")", iChunkDelay);
		}
		iChunk += iChunkStep;
	}

	// ----------------------------------------------------------
	// Global document onclick event handler
	// ----------------------------------------------------------

	document.onclick = DoMenu;
