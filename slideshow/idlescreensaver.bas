B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=13.1
@EndOfDesignText@
Sub Class_Globals
	Private mTimer As Timer
	Private mTimeTimer As Timer ' Timer for updating the time
	Private mPanel As Panel
	Private mImages As List
	Private mLabel As Label
	Private mCurrentIndex As Int = 0
	Public mInterval As Int = 5000 ' Default: 5 seconds
	Private mIsVisible As Boolean = False
	Private mElapsedTime As Int = 0 ' Track elapsed time for 10 seconds
End Sub

Public Sub Initialize(Activity As Activity,insterval As Int)
	mTimer.Initialize("timer",10000)
	mTimer.Interval = insterval
	mTimer.Enabled = True

	mPanel.Initialize("")
	mPanel.Color = Colors.Black
	Activity.AddView(mPanel, 0, 0, 100%x, 100%y)
    
	mLabel.Initialize("")
	mLabel.TextSize = 6%y
	mLabel.TextColor = Colors.White
	mLabel.Typeface = Typeface.SERIF
	mLabel.Typeface = Typeface.DEFAULT_BOLD
	mLabel.Gravity = Gravity.CENTER
	mPanel.AddView(mLabel, 0, 0, 100%x, 30%y) 
	
	' Fixed 3 images
	mImages.Initialize
	mImages.Add("cyduck.jpg")
	mImages.Add("pokemon.png")
	mImages.Add("profile.jpg")
	
	mTimeTimer.Initialize("TimeTick", 1000)
	mTimeTimer.Interval = mInterval
	mTimeTimer.Enabled = True
	
	mPanel.Visible = False
End Sub

Private Sub ShowNextImage
	If mImages.Size = 0 Then Return

	Dim img As ImageView
	img.Initialize("")
	img.Gravity = Gravity.FILL
	img.Bitmap = LoadBitmap(File.DirAssets, mImages.Get(mCurrentIndex))

	' Remove only image views to prevent deleting the label
	For i = mPanel.NumberOfViews - 1 To 0 Step -1
		If mPanel.GetView(i) Is ImageView Then
			mPanel.RemoveViewAt(i)
		End If
	Next

	mPanel.AddView(img, 0, 30%y, 100%x, 70%y)
	mCurrentIndex = (mCurrentIndex + 1) Mod mImages.Size
End Sub

Public Sub ShowScreenSaver(Show As Boolean)
	If Show Then
		If mImages.Size <= 0 Then Return
		mPanel.Visible = True
		mIsVisible = True
		ShowNextImage
		mTimer.Enabled = False
		mTimeTimer.Enabled = True ' Start time update
	Else
		mTimer.Enabled = True
		mTimeTimer.Enabled = False ' Stop time update
		mPanel.Visible = False
		mIsVisible = False
	End If
End Sub
Private Sub TimeTick_Tick
	mElapsedTime = mElapsedTime + 1

	If mElapsedTime >= 10 Then
		ShowScreenSaver(True)
		mElapsedTime = 0
	End If
    
	If mIsVisible Then ShowNextImage
End Sub
Sub timer_tick
	ShowScreenSaver(True)
	mTimer.Enabled = False
End Sub
