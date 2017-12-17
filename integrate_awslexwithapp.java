package io.github.satr.aws.lex;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.amazonaws.services.lexruntime.model.PostTextResult;

public class Main{
public static void main(String[] args){
AmazonLexRuntime client= AmazonLexRuntimeClientBuilder.standard()
			.withRegion(Regions.US_EAST_1).build();
PostTextRequest textRequest= new PostTextRequest();
textRequest.setBotName("Test bot");
textRequest.setBotAlias("testbotforRequest");
textRequest.setUserId("testuser");
Scanner scanner=new scanner(System.in);
while(true){
String requestText=scanner.nextLine().trim();
if(isEmpty(requestText))
break;
textRequest.setInputText(requestText);
PostTextResult textResult=client.postText(textRequest);
if(textResult.getDialogState().startsWith("Elicit"))
System.out.println(textResult.getMessage());
else if(textResult.getDialogState().equlas("ReadyForFullfillment"))
System.out.println(String.format("%s: %s",textResult.getIntentName(),textResult.getSlots());
else
System.out.println(textResult.toString());
textRequest.setInputText("who are online");
PostTextResult textResult = client.postText(textRequest);
System.out.println(textResult.getDialogState());
System.out.println(textResult.getMessage());
System.out.println(textResult.getIntentName());
System.out.println(textResult.getSlot());
}
}