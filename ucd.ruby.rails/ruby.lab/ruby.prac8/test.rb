def find_name_title(doca)
  unless doca.nil?
  then title = doca.search('//title').inner_text
       title.gsub(' - Wikipedia, the free encyclopedia', '')
  end
end
def strip_out_name(name, nameout = [])
  if name =~ /^http:\/\/en.wikipedia.org\/wiki\//
    nameout = name.gsub(/http:\/\/en.wikipedia.org\/wiki\//, '')
  elsif name =~ /^en.wikipedia.org\/wiki\//
    nameout = name.gsub(/en.wikipedia.org\/wiki\//, '')
  elsif name =~ /^\/wiki\//
    nameout = name.gsub(/\/wiki\//, '')
  elsif name != ~ URI::DEFAULT_PARSER.make_regexp || name.nil?
    print 'URI is not right in STRIP_OUT_NAME: '; p @in_uri.to_s
  end
  nameout
end


#################################################################3



def find_films_by_actor(doca, out = [])
  puts "Entering find_films_by_actor with #{find_name_title(doca)}."
  all_links = doca.search('//a[@href]')
  all_links.each do |link|
    link_info = link['href']
    if link_info.include?('(film)') &&
       !(link_info.include?('Category:') || link_info.include?('php'))
    then out << link_info end
  end
  out.uniq.collect { |link| strip_out_name(link) }
end
