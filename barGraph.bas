B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals
	Dim ActivityContext As Activity
End Sub

Public Sub Initialize(Activity As Activity,barPanel As Panel,sales() As Int, maxSale As Int)
	
	barPanel.Height = 380dip
	
	Dim activityPanel As Panel
	activityPanel.Initialize("activityPanel")
	
	activityPanel.Width = 1000dip
	activityPanel.Height = 200dip
	activityPanel.Color = Colors.ARGB(70, 211, 211, 211)
	
	Dim alignLeftCenter As Int = (Activity.Width - activityPanel.Width) / 2
	Dim alignTopCenter As Int = (barPanel.Height - activityPanel.Height) / 2
	
	Dim title As Label
	title.Initialize("")
	title.Text = "Total Sales For Companies"
	title.TextSize = 20
	title.Typeface = Typeface.MONOSPACE
	title.Gravity = Gravity.CENTER
	title.TextColor = Colors.Black
	barPanel.AddView(title,0,alignTopCenter/2,barPanel.Width,30dip)
	
	' Add the panel to the activity
	barPanel.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

	' Create a Canvas object to draw on the panel
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)

	' Sample data for the sales

	' Define the maximum sale value to scale the bars accordingly
	Dim maxSale As Int = 400000

	Dim gap As Int = 10dip
	If sales.Length < 5 Then
		Dim gap As Int = 50dip
	End If

	Dim endPadding As Int = 7dip
	' Calculate the adjusted bar width to account for spacing
	Dim barWidth As Int = (activityPanel.Width - (sales.Length - 1) * gap - endPadding) / sales.Length
	
	Dim cv As Canvas
	For i = 0 To sales.Length - 1
		Dim sale As Int = sales(i)

		' Calculate bar height based on sale value
		Dim barHeight As Int = (sale / maxSale) * activityPanel.Height

		' Calculate x-coordinate considering the gap
		Dim xPos As Int = i * (barWidth + gap)
		Dim r As Rect

		' Draw the shadow of the bar (slightly offset)
		Dim shadowOffset As Int = 5dip ' Set the offset for the shadow
		r.Initialize(xPos + shadowOffset, activityPanel.Height - barHeight + shadowOffset, xPos + barWidth + shadowOffset, activityPanel.Height + shadowOffset)
		graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100), True, 2dip) ' Dark gray shadow

		' Draw the actual bar on top of the shadow
		r.Initialize(xPos, activityPanel.Height - barHeight, xPos + barWidth, activityPanel.Height)
		graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), True, 2dip)
		
		r.Initialize(xPos + 200, activityPanel.Height - barHeight, xPos, activityPanel.Height)
		graphCanvas.DrawRect(r, Colors.Blue, True, 2dip)
		
		r.Initialize(xPos + 400, activityPanel.Height - barHeight, xPos, activityPanel.Height)
		graphCanvas.DrawRect(r, Colors.Green, True, 2dip)
		
		' Display the sales value above the bar
		Dim labelYPos As Int = activityPanel.Height - barHeight - 5dip ' Position the label 20 dip above the bar
		graphCanvas.DrawText(FormatNumberWithSuffix(sale), xPos + (barWidth / 2), labelYPos, Typeface.MONOSPACE, 14, Colors.black, "CENTER")
		
		
		cv.Initialize(barPanel)

		Dim productLabelY As Int = activityPanel.Height + alignTopCenter +20dip ' Position label below bars
		'cv.DrawTextRotated("Product SHOSAPODSPD " & (i + 1), (alignLeftCenter) + 25dip + xPos, productLabelY, Typeface.DEFAULT_BOLD, 12, Colors.Red, "CENTER", -45)
		Dim maxWidth As Int = 80dip ' Set max width for wrapping
		DrawWrappedTextRotated(cv, "Prince Warehouse" & (i + 1), (alignLeftCenter) + 10dip + xPos,(productLabelY)+5dip, maxWidth, 12, Colors.Red, "CENTER", -45)
	Next
	Dim numLabels As Int = 10
	For i = 0 To numLabels
		Dim labelValue As Int = (maxSale / numLabels) * i ' Calculate the corresponding value
		Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height) ' Adjust Y position based on the scale

		cv.DrawText(FormatNumberWithSuffix(labelValue), alignLeftCenter-35dip, labelYPos+ alignTopCenter +5dip, Typeface.MONOSPACE, 12, Colors.Black, "LEFT")
	Next
End Sub
Sub DrawGraph(Activity As Activity,barPanel As Panel,sales() As Int, maxSale As Int)
	barPanel.Initialize("")
	
	barPanel.Height = 380dip
	
	Dim activityPanel As Panel
	activityPanel.Initialize("activityPanel")
	
	activityPanel.Width = 400dip
	activityPanel.Height = 200dip
	activityPanel.Color = Colors.ARGB(70, 211, 211, 211)
	
	Dim alignLeftCenter As Int = (Activity.Width - activityPanel.Width) / 2
	Dim alignTopCenter As Int = (barPanel.Height - activityPanel.Height) / 2
	
	Dim title As Label
	title.Initialize("")
	title.Text = "Total Sales For Companies"
	title.TextSize = 20
	title.Typeface = Typeface.MONOSPACE
	title.Gravity = Gravity.CENTER
	title.TextColor = Colors.Black
	barPanel.AddView(title,0,alignTopCenter/2,barPanel.Width,30dip)
	
	' Add the panel to the activity
	barPanel.AddView(activityPanel, alignLeftCenter, alignTopCenter, activityPanel.Width, activityPanel.Height)

	' Create a Canvas object to draw on the panel
	Dim graphCanvas As Canvas
	graphCanvas.Initialize(activityPanel)

	' Sample data for the sales
	Dim sales() As Int
	sales = Array As Int(1000, 200000, 150000, 300000)

	' Define the maximum sale value to scale the bars accordingly
	Dim maxSale As Int = 400000

	Dim gap As Int = 10dip
	If sales.Length < 5 Then
		Dim gap As Int = 50dip
	End If

	Dim endPadding As Int = 7dip
	' Calculate the adjusted bar width to account for spacing
	Dim barWidth As Int = (activityPanel.Width - (sales.Length - 1) * gap - endPadding) / sales.Length
	
	Dim cv As Canvas
	For i = 0 To sales.Length - 1
		Dim sale As Int = sales(i)

		' Calculate bar height based on sale value
		Dim barHeight As Int = (sale / maxSale) * activityPanel.Height

		' Calculate x-coordinate considering the gap
		Dim xPos As Int = i * (barWidth + gap)
		Dim r As Rect

		' Draw the shadow of the bar (slightly offset)
		Dim shadowOffset As Int = 5dip ' Set the offset for the shadow
		r.Initialize(xPos + shadowOffset, activityPanel.Height - barHeight + shadowOffset, xPos + barWidth + shadowOffset, activityPanel.Height + shadowOffset)
		graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100), True, 2dip) ' Dark gray shadow

		' Draw the actual bar on top of the shadow
		r.Initialize(xPos, activityPanel.Height - barHeight, xPos + barWidth, activityPanel.Height)
		graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), True, 2dip)
		
		' Display the sales value above the bar
		Dim labelYPos As Int = activityPanel.Height - barHeight - 5dip ' Position the label 20 dip above the bar
		graphCanvas.DrawText(FormatNumberWithSuffix(sale), xPos + (barWidth / 2), labelYPos, Typeface.MONOSPACE, 14, Colors.black, "CENTER")
		
		
		cv.Initialize(barPanel)

		Dim productLabelY As Int = activityPanel.Height + alignTopCenter +20dip ' Position label below bars
		'cv.DrawTextRotated("Product SHOSAPODSPD " & (i + 1), (alignLeftCenter) + 25dip + xPos, productLabelY, Typeface.DEFAULT_BOLD, 12, Colors.Red, "CENTER", -45)
		Dim maxWidth As Int = 80dip ' Set max width for wrapping
		DrawWrappedTextRotated(cv, "Prince Warehouse" & (i + 1), (alignLeftCenter) + 10dip + xPos,(productLabelY)+5dip, maxWidth, 12, Colors.Red, "CENTER", -45)
	Next
	Dim numLabels As Int = 5
	For i = 0 To numLabels
		Dim labelValue As Int = (maxSale / numLabels) * i ' Calculate the corresponding value
		Dim labelYPos As Int = activityPanel.Height - ((labelValue / maxSale) * activityPanel.Height) ' Adjust Y position based on the scale

		cv.DrawText(FormatNumberWithSuffix(labelValue), alignLeftCenter-35dip, labelYPos+ alignTopCenter +5dip, Typeface.MONOSPACE, 12, Colors.Black, "LEFT")
	Next
End Sub

Sub FormatNumberWithSuffix(number As Int) As String
	If number >= 1000000 Then
		Return NumberFormat(number / 1000000, 1, 1) & "M"
	Else If number >= 1000 Then
		Return NumberFormat(number / 1000, 1, 1) & "k"
	Else
		Return NumberFormat(number, 1, 0)
	End If
End Sub

Sub DrawWrappedTextRotated(canvas As Canvas, text As String, x As Int, y As Int, maxWidth As Int, fontSize As Float, color As Int, alignment As String, angle As Float) As Int
	Dim words() As String = Regex.Split(" ", text)
	Dim line As String = ""
	Dim lineHeight As Int = 20dip ' Space between lines
	Dim originalY As Int = y ' Store original Y position

	For Each word As String In words
		Dim testLine As String = line & word & " "
		Dim textWidth As Int = canvas.MeasureStringWidth(testLine, Typeface.MONOSPACE, fontSize)

		If textWidth > maxWidth And line <> "" Then
			' Draw the current line
			canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
			y = y + lineHeight ' Move to next line
			line = word & " " ' Start new line
		Else
			line = testLine ' Add word to current line
		End If
	Next

	' Draw the last line
	If line <> "" Then
		canvas.DrawTextRotated(line, x, y, Typeface.DEFAULT_BOLD, fontSize, color, alignment, angle)
		y = y + lineHeight ' Move final Y position
	End If

	' Return the new height
	Return y - originalY
End Sub