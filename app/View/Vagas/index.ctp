<div class="mdl-cell mdl-cell--1-col"></div>
<div class="vagas index">
	<h2><?php echo __('Vagas'); ?></h2>
        <table class="table table-hover" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('designacao'); ?></th>
			<th><?php echo $this->Paginator->sort('concurso_id'); ?></th>
			<th><?php echo $this->Paginator->sort('carreira_id'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($vagas as $vaga): ?>
	<tr>
		<td><?php echo h($vaga['Vaga']['id']); ?>&nbsp;</td>
		<td><?php echo h($vaga['Vaga']['designacao']); ?>&nbsp;</td>
		<td>
			<?php echo $this->Html->link($vaga['Concurso']['nome'].' ['.$vaga['Concurso']['data_aprovacao'].']', array('controller' => 'concursos', 'action' => 'view', $vaga['Concurso']['id'])); ?>
		</td>
		<td>
			<?php echo $this->Html->link($vaga['Carreira']['nome'], array('controller' => 'carreiras', 'action' => 'view', $vaga['Carreira']['id'])); ?>
		</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $vaga['Vaga']['id'])); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $vaga['Vaga']['id'])); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $vaga['Vaga']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $vaga['Vaga']['id']))); ?>
		</td>
	</tr>
<?php endforeach; ?>
	</tbody>
	</table>
	<p>
	<?php
	echo $this->Paginator->counter(array(
		'format' => __('Page {:page} of {:pages}, showing {:current} records out of {:count} total, starting on record {:start}, ending on {:end}')
	));
	?>	</p>
	<div class="paging">
	<?php
		echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
		echo $this->Paginator->numbers(array('separator' => ''));
		echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled'));
	?>
	</div>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('New Vaga'), array('action' => 'add')); ?></li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
	</ul>
</div>
