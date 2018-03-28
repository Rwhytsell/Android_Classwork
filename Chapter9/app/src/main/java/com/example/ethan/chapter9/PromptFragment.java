package com.example.ethan.chapter9;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The type Prompt fragment.
 */
public class PromptFragment extends Fragment
{
    /**
     * Instantiates a new Prompt fragment.
     */
    public PromptFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_top_prompt, container, false);
    }
}
