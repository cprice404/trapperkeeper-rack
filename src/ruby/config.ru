puts "GEM PATH: #{Gem.path}"
puts "LOAD PATH: #{$LOAD_PATH}"
puts "$: : #{$:}"
require 'hello-sinatra'
run HelloSinatra