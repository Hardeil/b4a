B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
#Region  Activity Attributes 
    #FullScreen: False
    #IncludeTitle: False
#End Region

Sub Process_Globals
	
	Private xui As XUI
		
End Sub

Sub Globals
	Dim PHPURL As String = "https://192.168.8.141/sample/api.php?action=get_data"
	Dim TableDetails As List
	Private ScrollView1 As ScrollView
	Private ScrollViewPanel As Panel
	Private homeButn As Label
	Private studentListBtn As Label
	Private Panel1 As Panel
End Sub

Sub LoadMySQLData
	Dim Job1 As HttpJob
	Job1.Initialize("LoadData", Me)
	Job1.Download(PHPURL)
	ProgressDialogShow("Loading Data...")
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("crud")
	ScrollView1.Width = 100%x
	ScrollViewPanel.Initialize("")
	ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0, 100%x, 100%y)
	
	Dim SystemLabel As Label
	SystemLabel.Initialize("")
	SystemLabel.Text = "ATTENDANCE SYSTEM"
	SystemLabel.TextColor= Colors.White
	SystemLabel.TextSize = 30
	SystemLabel.Typeface = Typeface.CreateNew(Typeface.SERIF, Typeface.STYLE_Bold)
	Panel1.AddView(SystemLabel,20dip,40dip,100%x,70dip)
	Dim cvs As Canvas
	cvs.Initialize(Panel1)

	' Set the border color (black) and draw the bottom border
	cvs.DrawLine(0, Panel1.Height - 1, Panel1.Width, Panel1.Height - 1, Colors.ARGB(50, 0, 0, 0), 10)
	
	LoadMySQLData
End Sub


Sub JobDone(job As HttpJob)
	ProgressDialogHide
	If job.Success = True Then
		Try
			Dim parser As JSONParser
			parser.Initialize(job.GetString)
			TableDetails = parser.NextArray
            
			ScrollViewPanel.RemoveAllViews

			Dim YPos As Int = 0
			Dim Margin As Int = 10dip
			Dim TotalHeight As Int = 0 ' To calculate total height
			
			Dim id_display = 1 As Int
			For Each record As Map In TableDetails
				
				Dim name As String = record.Get("name")
				Dim imageBase64 As String = record.Get("image")

				Dim su As StringUtils
				Dim ImageBytes() As Byte = su.DecodeBase64(imageBase64)

				Dim ImageView As ImageView
				ImageView.Initialize("")
				ImageView.Gravity = Gravity.CENTER_HORIZONTAL

				Dim ImageBitmap As Bitmap
				Dim InputStream As InputStream
				InputStream.InitializeFromBytesArray(ImageBytes, 0, ImageBytes.Length)
				ImageBitmap.Initialize2(InputStream)

				' Resize the image
				ImageBitmap = ImageBitmap.Resize(100%x, 100%y, True)

				' Apply rounded transformation
				Dim RoundedBitmap As B4XBitmap = CreateRoundBitmap(ImageBitmap, 25%x)
				ImageView.Bitmap = RoundedBitmap

				Dim NameLabel As Label
				NameLabel.Initialize("")
				NameLabel.Text = name
				NameLabel.TextSize = 1%y
				NameLabel.TextColor = Colors.Black
				NameLabel.Typeface = Typeface.CreateNew(Typeface.SERIF, Typeface.STYLE_Bold)
				NameLabel.Gravity = Gravity.CENTER
				
				Dim StudentIdLabel As Label
				StudentIdLabel.Initialize("")
				StudentIdLabel.Text = "SCC-213123-123123"
				StudentIdLabel.TextSize = 15
				StudentIdLabel.TextColor = Colors.ARGB(255, 128, 128, 128)
				StudentIdLabel.Gravity = Gravity.CENTER
				NameLabel.Typeface = Typeface.CreateNew(Typeface.SERIF, Typeface.STYLE_NORMAL)
				
				NameLabel.Typeface = Typeface.DEFAULT_BOLD
				Dim ItemPanel As Panel
				ItemPanel.Initialize("")
				ItemPanel.SetLayout(0, YPos, ScrollView1.Width, 18%y)
				ItemPanel.Color = Colors.White

				Dim id As Label
				id.Initialize("")
				id.Text = id_display
				id.TextSize = 24
				
				Dim HorizontalLayout As Panel
				HorizontalLayout.Initialize("")
				HorizontalLayout.SetLayout(0, 0, ItemPanel.Width, ItemPanel.Height)

				HorizontalLayout.AddView(ImageView, 5%x, 2%y, 25%x, 25%x)
				HorizontalLayout.AddView(NameLabel, 25%x, 3%y, ItemPanel.Width - ImageView.Width, 5%y)
				HorizontalLayout.AddView(id, 3%x, 2%y, 5%x, 5%y)
				HorizontalLayout.AddView(StudentIdLabel, 25%x, 9%y, ItemPanel.Width - ImageView.Width, 5%y)
				HorizontalLayout.Color = Colors.LightGray
		
				HorizontalLayout.Color = Colors.White

				Log(Panel1.Width & "this is witdth")
				
				
				' Create a Canvas object to draw on the panel
				Dim cvs As Canvas
				cvs.Initialize(HorizontalLayout)

				' Set the border color (black)
				cvs.DrawLine(HorizontalLayout.Width, 0, HorizontalLayout.Width, HorizontalLayout.Height,Colors.ARGB(255, 16, 64, 34), 5dip) ' Right border
				cvs.DrawLine(HorizontalLayout.Width, HorizontalLayout.Height, 0, HorizontalLayout.Height, Colors.ARGB(255, 16, 64, 34), 5dip) ' Bottom border
				
				ItemPanel.AddView(HorizontalLayout, 0, 0, ItemPanel.Width, ItemPanel.Height)
				ScrollView1.Panel.AddView(ItemPanel, 0, YPos, ScrollView1.Width, ItemPanel.Height)

				YPos = YPos + ItemPanel.Height + Margin
				TotalHeight = YPos ' Update total height
				
				id_display = id_display + 1
			Next

			' Set the height of the ScrollView.Panel to accommodate all items
			ScrollView1.Panel.Height = Max(TotalHeight, 100%y) ' Ensure at least screen size

		Catch
			ToastMessageShow("Error parsing data", True)
		End Try
	Else
		ToastMessageShow("Error: " & job.ErrorMessage, True)
	End If
	job.Release
End Sub



Sub CreateRoundBitmap (Input As B4XBitmap, Size As Int) As B4XBitmap
	If Input.Width <> Input.Height Then
		'if the image is not square then we crop it to be a square.
		Dim l As Int = Min(Input.Width, Input.Height)
		Input = Input.Crop(Input.Width / 2 - l / 2, Input.Height / 2 - l / 2, l, l)
	End If
	Dim c As B4XCanvas
	Dim xview As B4XView = xui.CreatePanel("")
	xview.SetLayoutAnimated(0, 0, 0, Size, Size)
	c.Initialize(xview)
	Dim path As B4XPath
	path.InitializeOval(c.TargetRect)
	c.ClipPath(path)
	c.DrawBitmap(Input.Resize(Size, Size, False), c.TargetRect)
	c.RemoveClip
	c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.CenterY, c.TargetRect.Width / 2 - 2dip, Colors.ARGB(128, 0, 0, 0), False, 1dip) 'comment this line to remove the border
	c.Invalidate
	Dim res As B4XBitmap = c.CreateBitmap
	c.Release
	Return res
End Sub




Private Sub homeButn_Click
	StartActivity("Main")
	Activity.Finish
End Sub

Private Sub studentListBtn_Click
	StartActivity("Dash")
	Activity.Finish
End Sub