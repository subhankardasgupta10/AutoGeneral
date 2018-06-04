package sample.com.au.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Stack;
import java.util.TimeZone;
import sample.com.au.exception.AutoGeneralException;
import sample.com.au.model.AutoGeneralTopLevel;
import sample.com.au.model.AutoGeneralUpdateTopLevel;

public final class AutoGeneralService {

    public AutoGeneralService() {
    }

    public AutoGeneralTopLevel validateBrackets(String input) {
        AutoGeneralTopLevel autoGeneralTopLevel = new AutoGeneralTopLevel();
        try {
            if (null != input && input.length() > 0 && input.length() < 101) {
                autoGeneralTopLevel.setInput(input);
                autoGeneralTopLevel.setBalanced(isBalanced(input));
            } else {
                throw new AutoGeneralException("Must be between 1 and 100 chars long");
            }
        } catch (Exception ex) {
            throw new AutoGeneralException(ex.getMessage());
        }
        return autoGeneralTopLevel;
    }

    private static boolean isBalanced(String braces) {
        Stack<Character> stack = new Stack<>();
        for (char c : braces.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if((c == ')' && (stack.isEmpty() || stack.pop() != '(')) ||
                    (c == ']' && (stack.isEmpty() || stack.pop() != '[')) ||
                    (c == '}' && (stack.isEmpty() || stack.pop() != '{'))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public AutoGeneralUpdateTopLevel saveBrackets(AutoGeneralUpdateTopLevel input) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = new AutoGeneralUpdateTopLevel();
        DateFormat dateFormat;
        try {
            if (null != input && null != input.getText() && input.getText().length() > 0 &&
                    input.getText().length() < 101) {
                autoGeneralUpdateTopLevel.setText(input.getText());
                autoGeneralUpdateTopLevel.setCompleted(true); // after creation and saving the value
                autoGeneralUpdateTopLevel.setId(42); //auto generated number or fixed value after getting saved
                dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
                dateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Brisbane"));
                autoGeneralUpdateTopLevel.setCreatedAt(String.valueOf(dateFormat));
                //saveText () method to store the input values.
            } else {
                throw new AutoGeneralException("Must be between 1 and 100 chars long");
            }
        } catch (Exception ex) {
            throw new AutoGeneralException(ex.getMessage());
        }
        return autoGeneralUpdateTopLevel;
    }

    public AutoGeneralUpdateTopLevel getIdBrackets(int id) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = new AutoGeneralUpdateTopLevel();
        try {
            if (id > 0) {
                String input = "hello{}test"; //fetchInput(); input id should fetch value of text, completed and createdDate
                //if fetchInput() has no Id then return 400 error. Id not found.
                autoGeneralUpdateTopLevel.setText(input); // will be fetched value
                autoGeneralUpdateTopLevel.setCompleted(true); //will be fetched value
                autoGeneralUpdateTopLevel.setId(id);
                autoGeneralUpdateTopLevel.setCreatedAt("2017-10-13T01:50:58.735Z"); //value will be returned createdDate
            }
        } catch (Exception ex) {
            throw new AutoGeneralException(ex.getMessage());
        }
        return autoGeneralUpdateTopLevel;
    }

    public AutoGeneralUpdateTopLevel updateBrackets(int id, AutoGeneralUpdateTopLevel input) {
        AutoGeneralUpdateTopLevel autoGeneralUpdateTopLevel = new AutoGeneralUpdateTopLevel();
        try {
            if (null != input && null != input.getText() && input.getText().length() > 0 &&
                    input.getText().length() < 101) {
                autoGeneralUpdateTopLevel.setText(input.getText());
                autoGeneralUpdateTopLevel.setCompleted(input.isCompleted());
                // updateValue(); this method will update text and completed value of a given input ID and return createdDate.
                autoGeneralUpdateTopLevel.setId(id);
                autoGeneralUpdateTopLevel.setCreatedAt("2017-10-13T01:50:58.735Z"); //value will be returned createdDate
            } else {
                throw new AutoGeneralException("Must be between 1 and 100 chars long");
            }
        } catch (Exception ex) {
            throw new AutoGeneralException(ex.getMessage());
        }
        return autoGeneralUpdateTopLevel;
    }
}
