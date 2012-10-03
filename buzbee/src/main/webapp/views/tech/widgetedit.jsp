<!DOCTYPE html>
<%@ include file="tagincludes.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<sf:form id="widgetUploadForm" action="../widget/save"
					enctype="multipart/form-data" modelAttribute="widgetValue">

					<fieldset>
						<div class="control-group">
							<label class="control-label" for="txtTitle">Widget Title</label>
							<div class="controls">
								<sf:input id="txtTitle" path="title" class="input-xlarge" />
								<sf:hidden id="id" path="id" />
								<p class="help-block">Enter the title of the widget</p>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="txtDescription">Widget
								Description</label>
							<div class="controls">
								<sf:textarea id="txtDescription" path="description"
									class="input-xlarge" />
								
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="widgetFile">Widget File</label>
							<div class="controls">
								<sf:input path="widgetFile" type="file"></sf:input>
<!-- 								<p class="help-block">XML file that contains the content of
									the widget</p> -->
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="thumbnailFile">Widget
								Thumbnail</label>
							<div class="controls">
								<sf:input path="thumbnailFile" type="file"></sf:input>
<!-- 								<p class="help-block">Widget thumbnail picture that will be
									displayed in the widget titlebar</p> -->
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="screenshotFile">Widget
								Screenshot</label>
							<div class="controls">
								<sf:input path="screenshotFile" type="file"></sf:input>
<!-- 								<p class="help-block">Widget screenshot picture that will be
									displayed to the user while subscribing it</p> -->
							</div>
						</div>
						<div class="form-actions">
							<button type="submit" id="butSaveWidget" class="btn btn-primary ">Save
								Widget</button>
							<button class="btn">Cancel</button>
						</div>
					</fieldset>
				</sf:form>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function() {
		application.showHeading("Create / Edit Widget");
	});
</script>
</body>
</html>