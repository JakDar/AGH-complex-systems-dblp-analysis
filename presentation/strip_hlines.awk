BEGIN {
    prev_ln = 0
}

/(community|intersection)-table/ {
    prev_ln = NR
}

/<table/ {
    if (NR - prev_ln == 1){
        print gensub("hsides","none","g",$0) 
    }else{
        print $0
    }
}

/dependencies: \[/{
    print "dependencies: [ {src: './reveal.js-menu/menu.js'},"
}

/section id="slide/{
    print gensub("id=\"slide.*?\"","","g",$0)
}

!/(<table|dependencies: \[|section id="slide)/{
    print $0
}
