B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
Sub Process_Globals
	'Public HttpClient As HttpClient
	'Public Request As HttpRequest
End Sub

Sub Service_Create
	' Initialize the HttpClient
	HttpClient.Initialize("HttpClient")
End Sub

Sub Service_Start (StartingIntent As Intent)
	' Start your service here if needed
End Sub

Sub Service_Destroy
	' Clean up the HttpClient
	HttpClient.Dispose
End Sub

Sub Download(Url As String)
	Request.InitializeGet(Url)
	HttpClient.Execute(Request, 1)
End Sub

'Sub HttpClient_Response (Response As HttpResponse, TaskId As Int)
	' Handle the response here
	'If Response.IsSuccess Then
		' Successful response
	'	CallSubDelayed2(Main, "HttpUtils2Service_ResponseSuccess", Response)
	'Else
		' Error in response
	'	CallSubDelayed2(Main, "HttpUtils2Service_ResponseError", Response)
'	End If
'End Sub
